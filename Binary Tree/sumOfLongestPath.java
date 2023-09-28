import java.util.* ;
import java.io.*; 
/* Following is the TreeNode class
    class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }

}

*/

public class Solution {

    /*
    tc=> O(N)   n is the no. of nodes
    sc=> O(H) where H is the height of the tree
    */


     public static void solve(TreeNode root, int sum, int[] maxSum, int len, int[] maxLen) {
        // Base case
        if (root == null) {
            if (len > maxLen[0]) {
                maxLen[0] = len;
                maxSum[0] = sum;
            } else if (len == maxLen[0]) {
                maxSum[0] = Math.max(sum, maxSum[0]);
            }
            return;
        }

        sum += root.data;

        solve(root.left, sum, maxSum, len + 1, maxLen);
        solve(root.right, sum, maxSum, len + 1, maxLen);
    }

    public static int longestPath(TreeNode root) {
        int[] maxLen = {0};
        int[] maxSum = {Integer.MIN_VALUE};

        solve(root, 0, maxSum, 0, maxLen);

        return maxSum[0];
    }   
}