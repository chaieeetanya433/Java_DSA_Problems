
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

public class preOrderTraversal {

	// Root of Binary Tree
	Node root;

	preOrderTraversal() { root = null; }

	// Given a binary tree, print its nodes in inorder
	void printPreorder(Node node)
	{
		if (node == null)
			return;

        // First print the data of node
        System.out.print(node.key + " ");

		// Then recur on left child
		printPreorder(node.left);


		// Now recur on right child
		printPreorder(node.right);
	}

	// Driver code
	public static void main(String[] args)
	{
		preOrderTraversal tree = new preOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function call
		System.out.println(
			"preOrder traversal of binary tree is ");
		tree.printPreorder(tree.root);
	}
}
