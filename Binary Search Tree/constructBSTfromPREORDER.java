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
//tc => O(n) and sc=> O(1)
public class Solution {
    public static TreeNode bstFromPreorder(int[] preOrder, int bound, int[] i) {
       if (i[0] == preOrder.length || preOrder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preOrder[i[0]++]);
        root.left = bstFromPreorder(preOrder, root.data, i);
        root.right = bstFromPreorder(preOrder, bound, i);
        return root;
    }

    public static TreeNode preOrderTree(int[] preOrder) {
        // Initialize the index to 0
        int[] index = {0};
        return bstFromPreorder(preOrder, Integer.MAX_VALUE, index);
    } 
}