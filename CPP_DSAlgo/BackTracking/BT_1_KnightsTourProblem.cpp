/*
The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each
square exactly once.
*/
#include <iostream>
#include <iomanip>
#define MAX 8

using namespace std;

bool isMoveValid(int playedMove, int n, int currx, int curry, int &x, int &y)
{
    int playX[] = {2, 1, -1, -2, -2, -1,  1,  2};
    int playY[] = {1, 2,  2,  1, -1, -2, -2, -1};

    x = currx + playX[playedMove];
    y = curry + playY[playedMove];

    if(x >= 0 && x < n && y >= 0 && y < n)
        return true;
    else
        return false;
}

bool solveKnightsTourProblem(int chessBoard[][MAX], int n, int currx, int curry, int currMoveCount)
{
    if(currMoveCount >= n*n)
        return true;

    int i;
    int x = currx, y = curry;

    for(i = 0; i < 8; i++)
    {
        if(isMoveValid(i, n, currx, curry, x, y) && chessBoard[x][y] == -1)
        {
            currMoveCount++;
            chessBoard[x][y] = currMoveCount;
            if(solveKnightsTourProblem(chessBoard, n, x, y, currMoveCount))
                return true;
            else
            {
                chessBoard[x][y] = -1;
                currMoveCount--;
            }
        }//end of if
    }//end of for
    return false;
}

void knightsTourProblem()
{
    int chessBoard[MAX][MAX];
    int n = MAX;
    int i, j;

    //Initialize Solution space
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < n; j++)
        {
            chessBoard[i][j] = -1;
        }
    }

    //Initial position of knight
    int currx = 0;
    int curry = 0;

    chessBoard[currx][curry] = 1;

    int currMoveCount = 1;

    if(solveKnightsTourProblem(chessBoard, n, currx, curry, currMoveCount))
    {
        cout << "Solution found:\n";
        for(i = 0; i < n; i++)
        {
            for(j = 0; j < n; j++)
            {
                cout << setw(3) << chessBoard[i][j] << " ";
            }
            cout << endl;
        }
    }
    else
    {
        cout << "No solution found.\n";
        for(i = 0; i < n; i++)
        {
            for(j = 0; j < n; j++)
            {
                cout << setw(3) << chessBoard[i][j] << " ";
            }
            cout << endl;
        }
    }
}

int main()
{
    knightsTourProblem();
    return 0;
}
/*
Solution:
If all squares are visited
    print the solution
Else
   a) Add one of the next moves to solution vector and recursively
   check if this move leads to a solution. (A Knight can make maximum
   eight moves. We choose one of the 8 moves in this step).
   b) If the move chosen in the above step doesn't lead to a solution
   then remove this move from the solution vector and try other
   alternative moves.
   c) If none of the alternatives work then return false (Returning false
   will remove the previously added item in recursion and if false is
   returned by the initial call of recursion then "no solution exists" )
*/
