/*
Print a Binary Tree in Vertical Order | Set 1

Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9

The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
*/
#include <iostream>
#include<map>
#include<vector>

using namespace std;

struct node
{
	int info;
	struct node * left;
	struct node * right;
};

void preorder_display(struct node * p)
{
	if (p == NULL)
		return;
	cout << p -> info << " ";
	preorder_display(p -> left);
	preorder_display(p -> right);
}

void inorder_display(struct node * p)
{
	if (p == NULL)
		return;
	inorder_display(p -> left);
	cout << p -> info << " ";
	inorder_display(p -> right);
}

struct node * insert_node(struct node * p, int value, int isLeft)
{
	struct node * temp = new node;
	temp -> info = value;
	temp -> left = NULL;
	temp -> right = NULL;

	if(p == NULL)
		return temp;
	else if(isLeft)
		p -> left = temp;
	else
		p -> right = temp;
	return temp;
}

struct node * create_tree()
{
	struct node * root = NULL;
	struct node * p = NULL;
	root = insert_node(p, 1, 1);
	p = insert_node(root, 2, 1);
	p = insert_node(root, 3, 0);
	p = insert_node(root -> left, 4, 1);
	p = insert_node(root -> left, 5, 0);
	p = insert_node(root -> right, 6, 1);
	p = insert_node(root -> right, 7, 0);
	p = insert_node(root -> right -> left, 8, 0);
	p = insert_node(root -> right -> right, 9, 0);
	return root;
	/*
	Tree:
           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9
	*/
}

void traverseTree(struct node * p, int horDis, map <int, vector<int> > &m)
{
    if(p == NULL)
        return;

    m[horDis].push_back(p -> info);

    traverseTree(p -> left, horDis - 1, m);
    traverseTree(p -> right, horDis + 1, m);
}

void printHorDistance(struct node * p)
{
    map <int, vector<int> > m;

    traverseTree(p, 0, m);

    map <int, vector<int> >::iterator i;
    int j;
    //vector <int>::iterator j;
    for(i = m.begin(); i != m.end(); i++)
    {
        cout << "\nHorizontal Distance = " << (i -> first) << endl;
        for(j = 0; j < (i -> second).size(); j++)
        //for(j = i -> second.begin(); j != i -> second.end(); j++)
        {
            //cout << *j << " ";
            cout << i -> second[j] << " ";
        }
    }
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	cout << "\nHorizontal view of tree from left to right:\n";
	printHorDistance(root);
	cout << endl;
	return 0;
}
/*
Whenever we see a node in traversal, we go to the hash map entry and add the node to the hash map using HD as a key in map.
*/
