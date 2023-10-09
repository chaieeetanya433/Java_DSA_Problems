/*********************************************************

 Following is the BinaryTreeNode structure:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

 public class Solution {
    public static boolean searchInBST(BinaryTreeNode root, int x) {
        // Write your code here.
        //tc => average case - O(H) H-height of the tree
        //wc - O(N) N-no. of nodes
        if(root == null) {
            return false;
        } 

        if(root.data == x) {
            return true;
        } 
        else if(root.data > x) {
            return searchInBST(root.left, x);
        } 
        else {
            return searchInBST(root.right, x);
        }
    }
}