import java.util.*;

/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

public class Solution {

    public static boolean isSymmHelp(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1==root2;
        }
        if(root1.data != root2.data) {
            return false;
        }

        return isSymmHelp(root1.left, root2.right) && isSymmHelp(root1.right, root2.left);
    }
    public static boolean isSymmetric(TreeNode root) {
        // Write your code here.
        if(root == null) return true;
        return isSymmHelp(root.left, root.right);
    }
}
