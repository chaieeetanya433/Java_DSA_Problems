import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class heightOfBinaryTree {
    public static int heightOfBinaryTree(TreeNode root) {
        // Write your code here.
        if(root == null) {
            return 0;
        }

        int left = heightOfBinaryTree(root.left);
        int right = heightOfBinaryTree(root.right);

        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Height of the tree is : "+heightOfBinaryTree(root));
    }
}
