import java.util.*;
import java.io.*;


 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<T> {
	   T data;
	   BinaryTreeNode<T> left;
	   BinaryTreeNode<T> right;
	   
	   public BinaryTreeNode(T data) {
		   this.data = data;
	   }
    }

*************************************************************/



public class Solution {    
      private static BinaryTreeNode<Integer> solve(BinaryTreeNode<Integer> root, int targetNodeVal, int k) {
        // Base case
        if (root == null) {
            return null;
        }

        // If the current node is the target node, return it
        if (root.data == targetNodeVal) {
            if (k == 0) {
                return root; // Found the Kth ancestor
            }
            return null; // This is the target node, but not the Kth ancestor
        }

        // Recursively search in the left and right subtrees
        BinaryTreeNode<Integer> leftAncestor = solve(root.left, targetNodeVal, k);
        BinaryTreeNode<Integer> rightAncestor = solve(root.right, targetNodeVal, k);

        // If either left or right ancestor is found, reduce k
        if (leftAncestor != null || rightAncestor != null) {
            k--;
        }

        // If we found the Kth ancestor, return the current node
        if (k == 0) {
            return root;
        }

        // Return the left or right ancestor, whichever is found
        return (leftAncestor != null) ? leftAncestor : rightAncestor;
    }

    public static int findKthAncestor(BinaryTreeNode<Integer> root, int targetNodeVal, int kth) {
        BinaryTreeNode<Integer> kthAncestor = solve(root, targetNodeVal, kth);
        return (kthAncestor != null) ? kthAncestor.data : -1; // Return -1 if not found
    }
}    
