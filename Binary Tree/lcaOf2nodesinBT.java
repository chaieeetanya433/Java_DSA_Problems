//when the root is given in the function

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /*
    tc=>O(n); sc=>O(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case 
        if(root == null) {
            return null;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);

        if(leftAns != null && rightAns != null) {
            return root;
        }
        else if(leftAns != null && rightAns == null) {
            return leftAns;
        } 
        else if(leftAns == null && rightAns != null) {
            return rightAns;
        }
        else {
            return null;
        }
    }
}

//when the root is not given in the function

import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Tree Node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;

	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	  }
    }

*************************************************************/

public class Solution {
	public static int getDepth(BinaryTreeNode node) {
		int depth = 0;
		while(node != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}
	public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode n1, BinaryTreeNode n2) {
		// Write your code here.
		int depth1 = getDepth(n1);
		int depth2 = getDepth(n2);
		

		//adjust depths to make them equal
		while(depth1 > depth2) {
			n1 = n1.parent;
			depth1--;
		}

		while(depth2 > depth1) {
			n2 = n2.parent;
			depth2--;
		}

		//move both nodes up until they meet
		while(n1 != n2) {
			n1 = n1.parent;
			n2 = n2.parent;
		}

		return n1;	//this is the LCA
	}
}

