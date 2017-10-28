/*
Given an expression string exp , write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct
in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
*/
#include<iostream>

using namespace std;

struct node
{
    char data;
    struct node * next;
};

class Stack
{
    private:
        struct node * tos;
    public:
        Stack();
        ~Stack();
        bool isEmpty();
        void push(char ch);
        char pop();
};

Stack::Stack()
{
    tos = NULL;
}
Stack::~Stack()
{
    while(!isEmpty())
    {
        struct node * temp = tos;
        tos = tos -> next;
        delete temp;
    }
}
bool Stack::isEmpty()
{
    if(tos == NULL)
        return true;
    return false;
}
void Stack::push(char ch)
{
    struct node * temp = new node;
    if(temp == NULL)
    {
        cout << "\nOverflow. Data cannot be pushed.\n";
        return;
    }
    temp -> data = ch;
    temp -> next = tos;
    tos = temp;
}
char Stack::pop()
{
    if(isEmpty())
        return NULL;
    struct node * temp = tos;
    tos = tos -> next;
    char ch = temp -> data;
    delete temp;
    return ch;
}

bool match(char str, char ch)
{
    if((str == ']' && ch == '[')
            || (str == '}' && ch == '{')
            || (str == ')' && ch == '('))
        return true;
    return false;
}

bool areBracketsMatched(string str)
{
    if(str.empty())
        return true;
    Stack st;
    for(int i = 0; i < str.size(); i++)
    {
        if(str[i] == '[' || str[i] == '{' || str[i] == '(')
        {
            st.push(str[i]);
        }
        else if(str[i] == ']' || str[i] == '}' || str[i] == ')')
        {
            char ch = st.pop();
            if(!match(str[i], ch))
            {
                return false;
            }
        }
    }
    if(st.isEmpty())
        return true;
    return false;
}

int main()
{
    string str1 = "[(5+4)*{(5/7)-(5+(8/4))}]";//true
    string str2 = "[(5+4])";//false
    string str3 = "[1]";//true
    string str4 = "(2))";//false
    string true_str = ", brackets are matched.\n";
    string false_str = ", brackets are not matched.\n";

    bool res = areBracketsMatched(str1);
    cout << "\nFor string " << str1 << (res?true_str:false_str);

    res = areBracketsMatched(str2);
    cout << "\nFor string " << str2 << (res?true_str:false_str);

    res = areBracketsMatched(str3);
    cout << "\nFor string " << str3 << (res?true_str:false_str);

    res = areBracketsMatched(str4);
    cout << "\nFor string " << str4 << (res?true_str:false_str);

    return 0;
}
