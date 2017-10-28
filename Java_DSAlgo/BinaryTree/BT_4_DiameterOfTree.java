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
	int [] findDiameterUtil(Node p)
	{
		int a[] = new int[2];
		//a[0] for best including node, a[1] for best
		if(p == null)
			return a;
		int lA[] = findDiameterUtil(p.left);
		int rA[] = findDiameterUtil(p.right);
		
		//Overall best
		a[1] = lA[1];
		if(rA[1] > a[1])
			a[1] = rA[1];		
		if(lA[0] + rA[0] + 1 > a[1])
			a[1] = lA[0] + rA[0] + 1;
		
		//Best Including Node
		if(lA[0] >= rA[0])
			a[0] = lA[0] + 1;
		else
			a[0] = rA[0] + 1;
		
		return a;
	}
	int findDiameter()
	{
		if(root == null)
			return 0;
		int a[] = findDiameterUtil(root);
		return a[1];
	}
}
class BT_4_DiameterOfTree
{
	public static void main(String args[])
	{
		BinaryTree t = new BinaryTree(10);
		t.root.left = new Node(19);
		t.root.right = new Node(22);
		t.root.left.left = new Node(14);
		t.root.left.right = new Node(44);
		t.root.right.right = new Node(7);
		t.root.left.right.left = new Node(9);
		t.root.left.right.right = new Node(4);
		t.root.right.right.left = new Node(25);
		/*
		 * 				10
		 * 			   /  \
		 * 			 19    22
		 * 		    /  \     \
		 *  	  14	44    7
		 *             / \   /
		 * 			  9   4 25
		 */
		System.out.print("PreOrder Traversal: ");
		t.preOrder();
		
		System.out.print("\nInOrder Traversal: ");
		t.inOrder();
		
		System.out.print("\nDiameter of Tree: " + t.findDiameter());
	}
}
