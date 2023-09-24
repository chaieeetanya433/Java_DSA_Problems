
/*
 Time Complexity: O(N)
Auxiliary Space: If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree. 
 */

// Class containing left and right child of current
// node and key value
class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

public class postOrderTraversal {

	// Root of Binary Tree
	Node root;

	postOrderTraversal() { root = null; }

	// Given a binary tree, print its nodes according to the
	// "bottom-up" postorder traversal.
	void printPostorder(Node node)
	{
		if (node == null)
			return;

		// First recur on left subtree
		printPostorder(node.left);

		// Then recur on right subtree
		printPostorder(node.right);

		// Now deal with the node
		System.out.print(node.key + " ");
	}

	// Driver code
	public static void main(String[] args)
	{
		postOrderTraversal tree = new postOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function call
		System.out.println(
			"Postorder traversal of binary tree is ");
		tree.printPostorder(tree.root);
	}
}
