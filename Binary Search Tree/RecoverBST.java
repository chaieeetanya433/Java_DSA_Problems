//problem link: https://www.codingninjas.com/studio/problems/fix-bst_873137?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/*******************************************************
 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int x) {
         this.data = x;
         this.left = null;
         this.right = null;
     }
     TreeNode(int x, TreeNode left, TreeNode right) {
         this.data = x;
         this.left = left;
         this.right = right;
     }
 };
 *******************************************************/
public class Solution {
    private static TreeNode first;
    private static TreeNode prev;
    private static TreeNode middle;
    private static TreeNode last;

    private static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (prev != null && (root.data < prev.data)) {
            // If this is the first violation, mark these two nodes as 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                // If this is the second violation, mark this node as 'last'
                last = root;
            }
        }

        // Mark this node as the previous
        prev = root;
        inOrder(root.right);
    }

    public static TreeNode FixBST(TreeNode root) {
        // Reset the variables before calling inOrder
        first = middle = last = null;
        prev = null;

        inOrder(root);

        if (first != null && last != null) {
            int t = first.data;
            first.data = last.data;
            last.data = t;
        } else if (first != null && middle != null) {
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }

        return root;
    }
}