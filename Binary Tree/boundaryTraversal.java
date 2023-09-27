import java.util.*;
/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/


public class Solution {

    public static void traverseLeft(TreeNode root, List<Integer> ans) {
        //base case
        if((root == null) || (root.left == null && root.right == null)) { //matlab leaf node hai
            return;
        }

        ans.add(root.data);
        if(root.left != null) {
            traverseLeft(root.left, ans);
        } else {
            traverseLeft(root.right, ans);
        }

    }

    public static void traverseLeaf(TreeNode root, List<Integer> ans) {
        //base case
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }

        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);
    }

     public static void traverseRight(TreeNode root, List<Integer> ans) {
        //base case
        if((root == null) || (root.left == null && root.right == null)) { //matlab leaf node hai
            return;
        }

        if(root.right != null) {
            traverseRight(root.right, ans);
        } else {
            traverseRight(root.left, ans);
        }

        //wapas aagye 
        ans.add(root.data);

    }

    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        ans.add(root.data);

        //left part print/store
        traverseLeft(root.left, ans);

        //traverse Leaf node
        
        //left subtree
        traverseLeaf(root.left, ans);

        //right subtree
        traverseLeaf(root.right, ans);

        //traverse right part
        traverseRight(root.right, ans);

        return ans;
    }
}