class Node
{
	int data;
	Node left, right;
	Node()
	{
		data = 0;
		left = right = null;
	}
	Node(int info)
	{
		data = info;
		left = right = null;
	}
}
class BinaryTree
{
	Node root;
	BinaryTree()
	{
		root = null;
	}
	BinaryTree(int info)
	{
		root = new Node(info);
	}
	void preOrder(Node p)
	{
		if(p == null)
			return;
		else
		{
			System.out.print(p.data + " ");
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	void preOrder()
	{
		preOrder(root);
	}
	void inOrder(Node p)
	{
		if(p == null)
			return;
		else
		{
			inOrder(p.left);
			System.out.print(p.data + " ");
			inOrder(p.right);
		}
	}
	void inOrder()
	{
		inOrder(root);
	}
	int getHeight(Node p)
	{
		if(p == null)
			return 0;
		
		int lHeight = getHeight(p.left);
		int rHeight = getHeight(p.right);
		
		return ((lHeight >= rHeight)?(lHeight + 1):(rHeight + 1));
	}
	void levelOrderUtil(Node p, int h)
	{
		if(p == null)
			return;
		if(h == 0)
			System.out.print(p.data + " ");
		else
		{
			levelOrderUtil(p.left, h - 1);
			levelOrderUtil(p.right, h - 1);
		}
	}
	void levelOrder()
	{
		if(root == null)
			return;
		int h = getHeight(root);
		
		for(int i = 0; i < h; i++)
			levelOrderUtil(root, i);
	}
	
}
class BT_2_LevelOrderTraversalRecursion
{
	public static void main(String args[])
	{
		BinaryTree t = new BinaryTree(10);
		t.root.left = new Node(19);
		t.root.right = new Node(22);
		t.root.left.right = new Node(44);
		t.root.right.right = new Node(7);
		t.root.left.right.left = new Node(9);
		t.root.left.right.right = new Node(4);
		t.root.right.right.left = new Node(25);
		/*
		 * 				10
		 * 			   /  \
		 * 			 19    22
		 * 		       \     \
		 *  			44    7
		 *             / \   /
		 * 			  9   4 25
		 */
		System.out.print("PreOrder Traversal: ");
		t.preOrder();
		
		System.out.print("\nInOrder Traversal: ");
		t.inOrder();
		
		System.out.print("\nLevel-Order Traversal: ");
		t.levelOrder();		
	}
}
