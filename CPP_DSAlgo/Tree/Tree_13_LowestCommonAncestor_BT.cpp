/*
Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and 
n2 as descendants (where we allow a node to be a descendant of itself).
*/
#include <iostream>

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

void destroyTree(struct node * p)
{
	if (p == NULL)
		return;
	destroyTree(p -> left);
	destroyTree(p -> right);
	delete p;
}

struct node * findLCAUtil(struct node *p, int m, int n, bool & isMFound, bool & isNFound)
{
	if(p == NULL)
		return p;
	if(p -> info == m && p -> info == n)
	{
		isMFound = true;
		isNFound = true;
		return p;
	}
	else if(p -> info == m)
	{
		isMFound = true;
		return p;
	}
	else if(p -> info == n)
	{
		isNFound = true;
		return p;
	}
	
	struct node *lChild = findLCAUtil(p -> left, m, n, isMFound, isNFound);
	struct node *rChild = findLCAUtil(p -> right, m, n, isMFound, isNFound);
	
	if(lChild != NULL && rChild != NULL && isMFound && isNFound)
		return p;
	else if(lChild != NULL)
		return lChild;
	else
		return rChild;
}

bool findInChildren(struct node *p, int x)
{
	if(p == NULL)
		return false;
	if(p -> info == x || findInChildren(p -> left, x) || findInChildren(p -> right, x))
		return true;
	return false;
}

struct node * findLCA(struct node *p, int m, int n)
{
	if(p == NULL)
		return p;
	
	bool isMFound = false, isNFound = false;
	struct node * lcaPtr = findLCAUtil(p, m, n, isMFound, isNFound);
	
	if((isMFound && isNFound) || (isMFound && findInChildren(lcaPtr, n)) || (isNFound && findInChildren(lcaPtr, m)))
		return lcaPtr;
	return NULL;
}

int main()
{
	int m, n;
	struct node * root = create_tree();
	struct node *lca = NULL;
	cout << "Lowest Common AncestorProblem.\nPre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	cout << "\nEnter first Node = ";
	cin >> m;
	cout << "\nEnter second Node = ";
	cin >> n;
	lca = findLCA(root, m, n);
	if(lca == NULL)
		cout << "\nNo lowest common ancestor found.\n";
	else
		cout << "\nLCA (" << m << ", " << n << ") = " << lca -> info << ".\n";
	destroyTree(root);
	return 0;
}

