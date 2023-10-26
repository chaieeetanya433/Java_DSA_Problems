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

public class Solution {
    //tc=>O(n) and sc=>O(n)
    public static void inOrder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }
    public static int kthSmallest(TreeNode root, int k) {
        // Write your code here.
       if (root == null || k <= 0) {
            return -1; // Handle invalid input
        }

        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        if (k <= arr.size()) {
            return arr.get(k - 1);
        } else {
            return -1; // Handle the case when k is out of bounds.
        }
    }
}