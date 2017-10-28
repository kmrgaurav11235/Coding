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
class BinarySearchTree
{
	Node root;
	BinarySearchTree()
	{
		root = null;
	}
	BinarySearchTree(int info)
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
	Node findNode(Node p, int key)
	{
		if(p == null || p.data == key)
			return p;
		else if(key < p.data)
			return findNode(p.left, key);
		else
			return findNode(p.right, key);
	}
	boolean search(int key)
	{
		Node p = findNode(root, key);
		if(p == null)
			return false;
		else
			return true;
	}
	Node insert(int info)
	{
		
	}
	boolean delete(int info)
	{
		
	}
}
class BST_1_BinarySearchTree
{
	public static void main(String args[])
	{
		BinarySearchTree t = new BinarySearchTree(10);
		/* Creating following BST:
		 *               50
		 *            /     \
		 *           30      70
		 *          /  \    /  \
		 *        20   40  60   80 
		 */
        t.insert(50);
        t.insert(30);
        t.insert(20);
        t.insert(40);
        t.insert(70);
        t.insert(60);
        t.insert(80);
		System.out.print("PreOrder Traversal: ");
		t.preOrder();
		
		System.out.print("\nInOrder Traversal: ");
		t.inOrder();
		
		System.out.println("\nDelete 20");
        t.delete(20);
        System.out.println("Inorder traversal of the modified tree");
        t.inOrder();
 
        System.out.println("\nDelete 30");
        t.delete(30);
        System.out.println("Inorder traversal of the modified tree");
        t.inOrder();
 
        System.out.println("\nDelete 50");
        t.delete(50);
        System.out.println("Inorder traversal of the modified tree");
        t.inOrder();		
	}
}
