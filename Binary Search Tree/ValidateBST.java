import java.util.*;
/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */

public class Solution {
	//tc=>O(n) and sc=>O(1)
	public static boolean isValidBST(BinaryTreeNode<Integer> root, int minVal, int maxVal) {
		if(root == null) return true;

		if(root.data <= minVal || root.data >= maxVal) return false;

		return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}