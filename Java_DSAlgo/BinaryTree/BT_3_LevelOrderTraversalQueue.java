import java.util.LinkedList;
import java.util.Queue;
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
	void levelOrder()
	{
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty())
		{
			Node p = q.poll();
			System.out.print(p.data + " ");
			if(p.left != null)
				q.offer(p.left);
			if(p.right != null)
				q.offer(p.right);
		}
	}
}
class BT_3_LevelOrderTraversalQueue
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
