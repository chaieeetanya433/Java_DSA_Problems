import java.util.*;

/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

// tc = O(n) and sc = O(1)
public class Solution {
    public static int inOrderSuccessor(TreeNode root, int key) {
        int successor = -1;
        while(root != null) {
            if(key >= root.data) {
                root = root.right;
            } else {
                successor = root.data;
                root = root.left;
            }
        }
        return successor;
    }
    public static int inOrderPredecessor(TreeNode root, int key) {
        int predecessor = -1;
        while(root != null) {
            if(key <= root.data) {
                root = root.left;
            } else {
                predecessor = root.data;
                root = root.right;
            }
        }
        return predecessor;
    }
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        ans.add(inOrderPredecessor(root, key));
        ans.add(inOrderSuccessor(root, key));
        return ans;
    }
}