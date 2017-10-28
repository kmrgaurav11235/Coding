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
	void postOrder(Node p)
	{
		if(p == null)
			return;
		else
		{
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data + " ");
		}
	}
	void postOrder()
	{
		postOrder(root);
	}
}
class BT_1_TreeTraversal
{
	public static void main(String args[])
	{
		BinaryTree t = new BinaryTree(10);
		t.root.left = new Node(19);
		t.root.right = new Node(22);
		t.root.left.right = new Node(44);
		t.root.right.right = new Node(7);
		/*
		 * 				10
		 * 			   /  \
		 * 			 19    22
		 * 		       \     \
		 *  			44    7
		 */
		System.out.print("PreOrder Traversal: ");
		t.preOrder();
		
		System.out.print("\nInOrder Traversal: ");
		t.inOrder();
		
		System.out.print("\nPostOrder Traversal: ");
		t.postOrder();
	}
}
