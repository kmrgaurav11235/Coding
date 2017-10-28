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

	/*Tree
             20
            /
           10
          /
         5
        /
       2
        \
         3
	*/
	root = insert_node(p, 20, 1);
	p = insert_node(root, 10, 1);
	p = insert_node(p, 5, 1);
	p = insert_node(p, 2, 1);
	p = insert_node(p, 3, 0);

	//root = insert_node(p, 10, 1);
	//p = insert_node(root, 7, 1);
	//p = insert_node(root, 19, 0);
	//p = insert_node(root -> left, 3, 1);
	//p = insert_node(root -> left, 9, 0);
	//p = insert_node(root -> right, 23, 0);
	//p = insert_node(p, 16, 1);
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
	
	return root;
}

void destroyTree(struct node * p)
{
	if (p == NULL)
		return;
	destroyTree(p -> left);
	destroyTree(p -> right);
	delete p;
}

struct node * findLCAInBST(struct node *p, int m, int n)
{
	if(m > n)
	{
		int temp = m;
		m = n;
		n = temp;
	}
	
	while(p != NULL)
	{
		if(m < p -> info && n < p -> info)
			p = p -> left;
		else if(m > p -> info && n > p -> info)
			p = p -> right;
		else
			break;
	}
	return p;
}

int main()
{
	int m, n;
	struct node * root = create_tree();
	struct node *lca = NULL;
	cout << "Lowest Common AncestorProblem for Binary Search Tree.\nPre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);
	cout << "\nEnter first Node = ";
	cin >> m;
	cout << "\nEnter second Node = ";
	cin >> n;
	lca = findLCAInBST(root, m, n);
	if(lca == NULL)
		cout << "\nNo lowest common ancestor found.\n";
	else
		cout << "\nLCA (" << m << ", " << n << ") = " << lca -> info << ".\n";
	destroyTree(root);
	return 0;
}

