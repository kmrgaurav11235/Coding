/*Given a Binary Tree, print top and bottom view of it.
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
Bottom View is
2 4 5 6

If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. 
For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.

                   
                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \      
                  10    14 

For the above tree the bottom view should be 5, 10, 4, 14, 25.

*/
#include <iostream>
#include <map>

using namespace std;

struct node
{
	int data;
	struct node * left;
	struct node * right;
};

void preorder_display(struct node * p)
{
	if (p == NULL)
		return;
	cout << p -> data << " ";
	preorder_display(p -> left);
	preorder_display(p -> right);
}

void inorder_display(struct node * p)
{
	if (p == NULL)
		return;
	inorder_display(p -> left);
	cout << p -> data << " ";
	inorder_display(p -> right);
}

struct node * insert_node(struct node * p, int value, int isLeft)
{
	struct node * temp = new node;
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

int heightOfTree(struct node * p)
{
	if(p == NULL)
		return 0;
	int lHeight = heightOfTree(p -> left);
	int rHeight = heightOfTree(p -> right);
	return ((lHeight >= rHeight)?(lHeight + 1):(rHeight + 1));
}

void topLevelOrderTraversal(struct node * p, int reqLevel,int currLevel, int horDis, map <int, int> & m)
{
    if(p == NULL)
        return;
    if(currLevel == reqLevel && (!m[horDis]))
    {
        m[horDis] = p -> data;
        return;
    }
    topLevelOrderTraversal(p -> left, reqLevel, currLevel + 1, horDis - 1, m);
    topLevelOrderTraversal(p -> right, reqLevel, currLevel + 1, horDis + 1, m);
}

void bottomLevelOrderTraversal(struct node * p, int reqLevel,int currLevel, int horDis, map <int, int> & m)
{
    if(p == NULL)
        return;
    if(currLevel == reqLevel)
    {
        m[horDis] = p -> data;
        return;
    }
    bottomLevelOrderTraversal(p -> left, reqLevel, currLevel + 1, horDis - 1, m);
    bottomLevelOrderTraversal(p -> right, reqLevel, currLevel + 1, horDis + 1, m);
}

void topViewOfTree(struct node * p)
{
	map <int, int> m;
	int h = heightOfTree(p);
	
	for(int i = 0; i < h; i++)
		topLevelOrderTraversal(p, i , 0, 0, m);
		
	map <int, int>::iterator i;
	for(i = m.begin(); i != m.end(); i++)
		cout << i -> second << " ";
}

void bottomViewOfTree(struct node * p)
{
	map <int, int> m;
	int h = heightOfTree(p);
	
	for(int i = 0; i < h; i++)
		bottomLevelOrderTraversal(p, i , 0, 0, m);
		
	map <int, int>::iterator i;
	for(i = m.begin(); i != m.end(); i++)
		cout << i -> second << " ";
}

int main()
{
	struct node * root = create_tree();
	cout << "Pre-Order Disply of Tree:\n";
	preorder_display(root);
	cout << "\n\nIn-Order Disply of Tree:\n";
	inorder_display(root);

	cout << "\nTop View of this Binary Tree:\n";
	topViewOfTree(root);
	cout << endl;
	
	cout << "\nBottom View of this Binary Tree:\n";
	bottomViewOfTree(root);
	cout << endl;

	return 0;
}

//Modified Queues can be used for level order traversal too
