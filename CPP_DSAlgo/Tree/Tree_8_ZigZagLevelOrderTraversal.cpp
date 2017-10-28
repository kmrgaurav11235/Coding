//Given a Binary Tree and a sum, print the Level Order Traversal without using Queue.
//Level Order Traversal using queue is in Graph folder.

#include <iostream>

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
	struct Node * temp = new Node;
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

int heightOfTree(struct Node * p)
{
    if(p == NULL)
        return 0;
    int lHeight = heightOfTree(p -> left);
    int rHeight = heightOfTree(p -> right);
    if(lHeight > rHeight)
        return (lHeight + 1);
    else
        return (rHeight + 1);
}

void printNodeOnLevel(struct Node * p, int level, bool isOrderL2R)
{
    if(p == NULL)
        return;
    else if(level == 0)
        cout << p -> data << " ";
    else if(isOrderL2R)
    {
        printNodeOnLevel(p -> left, level - 1, isOrderL2R);
        printNodeOnLevel(p -> right, level - 1, isOrderL2R);
    }
    else
    {
        printNodeOnLevel(p -> right, level - 1, isOrderL2R);
        printNodeOnLevel(p -> left, level - 1, isOrderL2R);
    }
}

void ZZLevelOrderTraversal(struct Node * root)
{
    int height = heightOfTree(root);
    bool isOrderL2R = false;
    for(int i = 0; i < height; i++)
    {
        printNodeOnLevel(root, i, isOrderL2R);
        isOrderL2R = !isOrderL2R;
    }
}

int main()
{
	struct Node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);

	cout << "\nZig-Zag Level Order Traversal of this Binary Tree:\n";
	ZZLevelOrderTraversal(root);
	cout << endl;

	return 0;
}
