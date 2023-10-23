/*********************************************************

 Following is the BinaryTreeNode structure:

 class BinaryTreeNode<T> {
     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;
     BinaryTreeNode() {
         this.data = null;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(T data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

 public class Solution {
    public static BinaryTreeNode<Integer> inOrderSuccessor(BinaryTreeNode<Integer> root) {
        while(root.left != null) {
            root = root.left;
        } 

        return root;
    }

    public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
        // Write your code here.
        if (root == null) {
            return null;
        }

        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else { // root.data == key
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> IS = inOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteNode(root.right, IS.data);
            }
        }

        return root;
    }
}