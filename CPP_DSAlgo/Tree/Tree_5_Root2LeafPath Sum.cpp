//Given a Binary Tree and a sum, check whether there is a root to leaf path in that tree with the following sum.

#include <iostream>
#include <malloc.h>
#include <climits>

using namespace std;

struct Node
{
	int data;
	struct Node * left;
	struct Node * right;
};

void preorder_display(struct Node * p)
{
	if (p == NULL)
		return;
	cout << p -> data << " ";
	preorder_display(p -> left);
	preorder_display(p -> right);
}

void inorder_display(struct Node * p)
{
	if (p == NULL)
		return;
	inorder_display(p -> left);
	cout << p -> data << " ";
	inorder_display(p -> right);
}

struct Node * insert_node(struct Node * p, int value, int isLeft)
{
	struct Node * temp = (struct Node *)malloc(sizeof(struct Node));
	temp -> data = value;
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

struct Node * create_tree()
{
	struct Node * root = NULL;
	struct Node * p = NULL;
	root = insert_node(p, 10, 1);
	p = insert_node(root, 7, 1);
	p = insert_node(root, 19, 0);
	p = insert_node(root -> left, 3, 1);
	p = insert_node(root -> left, 9, 0);
	p = insert_node(root -> right, 23, 0);
	p = insert_node(p, 16, 1);
	return root;
	/*
	Tree:
	                    10
	                   /  \
	                  7    19
	                /  \     \
	               3    9    23
	                        /
	                       16
	*/
}

bool hasPathSum(struct Node *p, int sum)
{
	if(p == NULL)
		return false;

	int info = p -> data;
	sum = sum - info;

	if(sum < 0)
		return false;
    else if (p -> left == NULL && p -> right == NULL)//leaf
    {
        if(sum == 0)
            return true;
        else
            return false;
    }

	return (hasPathSum(p -> left, sum) || hasPathSum(p -> right, sum));
}

int main()
{
	struct Node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);

	int pathSum = 26;

	cout << "\nIs there a root to leaf path in this Binary Tree with Sum = " << pathSum << "? " << (hasPathSum(root, pathSum)?"yes":"no") << endl;
	return 0;
}
