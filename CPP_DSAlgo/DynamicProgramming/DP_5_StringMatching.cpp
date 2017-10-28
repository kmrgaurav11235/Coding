/*Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if wildcard pattern is matched with text.
The matching should cover the entire text (not partial text).

The wildcard pattern can include the characters ‘?’ and ‘*’
‘?’ – matches any single character
‘*’ – Matches any sequence of characters (including the empty sequence)

For example,

Text = "baaabab",
Pattern = “*****ba*****ab", output : true
Pattern = "baaa?ab", output : true
Pattern = "ba*a?", output : true
Pattern = "a*ab", output : false
*/

#include <iostream>

using namespace std;

bool stringMatching(string text, string pattern)
{
    int n = text.size();
    int m = pattern.size();

    if(n == 0 && m == 0)
        return true;

    int i, j;

    bool strMatch[n + 1][m + 1];

    for(i = 0; i <= n; i++)
        for(j = 0; j <= m; j++)
            strMatch[i][j] = false;

    strMatch[0][0] = true;

    for(j = 1; j <= m; j++)
        if(pattern[j - 1] == '*')
            strMatch[0][j] = strMatch[0][j - 1];

    for(i = 1; i <= n; i++)
    {
        for(j = 1; j <= m; j++)
        {
            if((pattern[j - 1] == text[i - 1]) || (pattern[j - 1] == '?'))
                strMatch[i][j] = strMatch[i - 1][j - 1];
            else if(pattern[j - 1] == '*')
                strMatch[i][j] = strMatch[i - 1][j] || strMatch[i][j - 1];
            else
                strMatch[i][j] = false;
        }
    }

    return strMatch[n][m];
}

int main()
{
    string text = "baaabab";
    string pattern1 = "*****ba*****ab";
    string pattern2 = "baaa?ab";
    string pattern3 = "ba*a?";
    string pattern4 = "a*ab";

    cout << "Matching string " << text << " with pattern " << pattern1
            << ": Solution = " << (stringMatching(text, pattern1)?"Yes.":"No.") << endl;

    cout << "Matching string " << text << " with pattern " << pattern2
            << ": Solution = " << (stringMatching(text, pattern2)?"Yes.":"No.") << endl;

    cout << "Matching string " << text << " with pattern " << pattern3
            << ": Solution = " << (stringMatching(text, pattern3)?"Yes.":"No.") << endl;

    cout << "Matching string " << text << " with pattern " << pattern4
            << ": Solution = " << (stringMatching(text, pattern4)?"Yes.":"No.") << endl;

    return 0;
}
