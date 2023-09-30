
import java.util.*;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(int data) {
        val = data;
        this.right = null;
        this.left = null;
    }
}

public class morrisPreorderTraversal {
    public static List<Integer> preorderMorris(TreeNode root) {
           //Moris preorder traversal
        /*
            tc => O(n)
            sc => O(1)
         */

        List<Integer> preorder = new ArrayList<Integer>(); 
        
        TreeNode cur = root; 
        while(cur != null) {
            if(cur.left == null) {   //the case where left subtree or node doesn't exists
                preorder.add(cur.val); 
                cur = cur.right; 
            }
            else {
                TreeNode prev = cur.left; 
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {     //here we;re connecting rightmost node of left subtree to the root node 
                    prev.right = cur;
                    preorder.add(cur.val); 
                    cur = cur.left; 
                }
                else {
                    prev.right = null;  //here we're breaking the threaded connection once we visit that node and come to the root so that curr will now go to right subtree
                    cur = cur.right; 
                }
            }
        }
        return preorder; 
    }

    public static void main(String[] args) {
        
    }
}
