import java.util.*;

/*******************************************************

 Following is the BinaryTreeNode class structure:

 class BinaryTreeNode<T> {
     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;

     public BinaryTreeNode(T data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *******************************************************/

public class Solution {
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        // Write you code here.
        //tc=>O(n)
        //space complexity of the identicalTrees function is O(h), where "h" is the height of the binary tree, and it can range from O(log n) to O(n) depending on the shape of the trees.
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null && root2 != null) {
            return false;
        }
        if(root1 != null && root2 == null) {
            return false;
        }

        boolean left = identicalTrees(root1.left, root2.left);
        boolean right = identicalTrees(root1.right, root2.right);

        boolean value = root1.data == root2.data;

        if(left == true && right == true && value == true) {
            return true;
        } else {
            return false;
        }
    }
}