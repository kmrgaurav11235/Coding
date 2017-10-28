/*
Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and 
n2 as descendants (where we allow a node to be a descendant of itself).
For this case, the parent pointer is available.
*/
#include <iostream>

using namespace std;

struct node
{
	int info;
	struct node * left;
	struct node * right;
	struct node * parent;
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
    temp -> parent = p;
	
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

void lcaUtil(struct node * p, int m, int n, struct node ** mP, struct node ** nP, int & mDepth, int & nDepth, int currDepth)
{
	if(p == NULL)
		return;
	if(p -> info == m)
	{
		*mP = p;
		mDepth = currDepth;
	}
	if(p -> info == n)
	{
		*nP = p;
		nDepth = currDepth;
	}
	if(mDepth != -1 && nDepth != -1)
		return;
	
	lcaUtil(p -> left, m, n, mP, nP, mDepth, nDepth, currDepth + 1);
	if(mDepth != -1 && nDepth != -1)
		return;
	else
		lcaUtil(p -> right, m, n, mP, nP, mDepth, nDepth, currDepth + 1);
}

struct node * findLCA(struct node * root, int m, int n)
{
	struct node * mPtr = NULL;
	struct node * nPtr = NULL;
	int mDepth = -1, nDepth = -1, currDepth = 0;
	
	//Find the pointers for m and n nodes and their depths
	lcaUtil(root, m, n, &mPtr, &nPtr, mDepth, nDepth, currDepth);
	
	if(mDepth != -1 && nDepth != -1)
	{
		if(mDepth > nDepth)
		{
			for(int i = 0; i < (mDepth - nDepth); i++)
				mPtr = mPtr -> parent;
		}
		else if(mDepth < nDepth)
		{
			for(int i = 0; i < (nDepth - mDepth); i++)
				nPtr = nPtr -> parent;
		}
		while(mPtr != NULL || nPtr != NULL)
		{
			if(mPtr == nPtr)
				return mPtr;
			else
			{
				mPtr = mPtr -> parent;
				nPtr = nPtr -> parent;
			}
		}
	}
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


