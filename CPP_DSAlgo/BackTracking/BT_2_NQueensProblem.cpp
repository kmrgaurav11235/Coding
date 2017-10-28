//The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
#include <iostream>
#define MAX 100

using namespace std;

void displayBoard(bool chessBoard[][MAX], int n)
{
    int i, j;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < n; j++)
        {
            if(chessBoard[i][j])
                cout << "Q ";
            else
                cout << "- ";
        }
        cout << endl;
    }

}

bool isSquareSafe(bool chessBoard[][MAX], int n, int currRow, int currCol)
{
    int i, j;

    if(currRow >= n || currCol >= n)
        return false;

    //Check above
    for(i = 0; i < currRow; i++)
        if(chessBoard[i][currCol])
            return false;

    //Check diagnol to top-left
    for(i = currRow, j = currCol; i >= 0 && j >= 0; i--, j--)
        if(chessBoard[i][j])
            return false;

    //Check diagnol to top-right
    for(i = currRow, j = currCol; i >= 0 && j < n; i--, j++)
        if(chessBoard[i][j])
            return false;

    return true;
}

bool solveNQueenProblemUtil(bool chessBoard[][MAX], int n, int currRow, int queenCount)
{
    if(queenCount == n)
        return true;
    else if(currRow >= n)
        return false;

    int i;

    for(i = 0; i < n; i++)
    {
        if(isSquareSafe(chessBoard, n, currRow, i))
        {
            chessBoard[currRow][i] = 1;
            if(solveNQueenProblemUtil(chessBoard, n, currRow + 1, queenCount + 1))
                return true;
            else
            {
                chessBoard[currRow][i] = 0;
            }//end of if-else
        }//end of if
    }//end of for

    return false;
}

void solveNQueenProblem(int n)
{
    bool chessBoard [MAX][MAX];
    int i, j;
    int queenCount = 0, currRow = 0;

    for(i = 0; i < n; i++)
        for(j = 0; j < n; j++)
            chessBoard[i][j] = false;

    if(solveNQueenProblemUtil(chessBoard, n, currRow, queenCount))
    {
        cout << "\nSolution found.\n";
        displayBoard(chessBoard, n);
    }
    else
        cout << "\nNo Solution found.\n";
}

int main()
{
    int n;
    cout << "N-Queen Problem. Time take will increase exponentially with increase in N.\nEnter N(2 <= N <= 100): ";
    cin >> n;
    if(n >= 2 && n <= 100)
    {
        solveNQueenProblem(n);
    }
    else
    {
        cout << "\nInvalid value of n.\n";
    }
    return 0;
}

/*
Solution:
1) Start in the leftmost column
2) If all queens are placed
    return true
3) Try all rows in the current column.  Do following for every tried row.
    a) If the queen can be placed safely in this row then mark this [row,
        column] as part of the solution and recursively check if placing
        queen here leads to a solution.
    b) If placing queen in [row, column] leads to a solution then return
        true.
    c) If placing queen doesn't lead to a solution then umark this [row,
        column] (Backtrack) and go to step (a) to try other rows.
3) If all rows have been tried and nothing worked, return false to trigger
    backtracking.
*/
