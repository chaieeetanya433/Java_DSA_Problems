import java.util.*;

/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
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
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

class NodeValue{
    public int minNode, maxNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize; 
    }
};


public class Solution {

    //tc=>O(n) and sc=>(1)
    public static NodeValue largestBSTSubtree(TreeNode root) {
        //an empty tree is a bst of size 0
        if(root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        //get values from left and right subtree of current tree
        NodeValue left = largestBSTSubtree(root.left);
        NodeValue right = largestBSTSubtree(root.right);

        //current node is greater than max in left and smaller than min in right, it is a bst
        if(left.maxNode < root.data && root.data < right.minNode) {
            //it is a bst
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), left.maxSize + right.maxSize + 1);
        } 

        //otherwise return [-infinity, +infinity] so that parent can't be valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    public static int largestBST(TreeNode root) {
        // Write your code here.
        return largestBSTSubtree(root).maxSize;
    }
}