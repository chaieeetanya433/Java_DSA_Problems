
/*
 Time Complexity: O(N)
Auxiliary Space: If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree. 
 */

// Class containing left and right child of current
// node and key value
import java.io.*;
import java.util.*;

class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

public class inOrderTraversal {

	// Root of Binary Tree
	Node root;

	inOrderTraversal() { root = null; }

	// Given a binary tree, print its nodes in inorder
	void printInorder(Node node)
	{
		if (node == null)
			return;

		// First recur on left child
		printInorder(node.left);

		// Then print the data of node
		System.out.print(node.key + " ");

		// Now recur on right child
		printInorder(node.right);
	}

	// Driver code
	public static void main(String[] args)
	{
		inOrderTraversal tree = new inOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function call
		System.out.println(
			"Inorder traversal of binary tree is ");
		tree.printInorder(tree.root);
	}
}
