/*
Every number with 3 at it’s unit place has a multiple which has all 1’s like for 3,the multiple is 111,for 13 multiple is 111111.
The multiple can exceed the integer range i.e,it can be very large number(try storing it in a string).
*/
#include<iostream>

using namespace std;

string createString(int size)
{
    string res = "";
    for(int i = 0; i < size; i++)
    {
        res = res + "1";
    }
    return res;
}

string findSmallestMultiple(int n)
{
    int count_i;
    int reminder = 1;

    for(count_i = 1; count_i <= n; count_i++)
    {
        if(reminder == 0)
        {
            return createString(count_i);
        }
        else
        {
            reminder = (10 * reminder + 1) % n;
        }
    }
    return "";
}

int main()
{
    int n;
    cout << "Enter the number whose multiple you want to find: ";
    cin >> n;
    string res = findSmallestMultiple(n);
    if(res.empty())
        cout << "\nNo multiple found.\n";
    else
        cout << "\nThe multiple is " << res << endl;
    return 0;
}

/*
Solution:
---------------------------------------------------------------------------------------------------------------------
Coding any working brute-force algorithm is relatively easy.

Alternative:
Shorthand notation: let M(i) mean 1111...1 (i ones).
Given a number n (let's say n = 23), you want to find a number m such that M(m) is divisible by n.
Assume that you already know, from previous iterations, the value of M(i) mod n.
If M(i) mod n = 0, then you're done (M(i) is the answer), so let's assume it's not.
You want to find M(i+1) mod n. Since M(i+1) = 10 * M(i) + 1, you can easily calculate M(i+1) mod n
, as it's (10 * (M(i) mod n) + 1) mod n.

Q; Why counti is initialized to 1 and why it jterates until n?


m is initialized to 1 because counti is initially 1 and we have the invariant m = M(i) mod n.
counti iterates until n because there are at most n different values of m and they loop in a cycle of
length not greater than n (this is because each next value of m is a function of the previous one).
So if we cannot find m = 0 among the first n values, we will never find it.

*/
