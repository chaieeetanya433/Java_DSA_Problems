import java.util.*;

class BinaryTreeNode<T> {
     public T data;
     public BinaryTreeNode<T> left;
     public BinaryTreeNode<T> right;

     BinaryTreeNode(T data) {
         this.data = data;
         left = null;
         right = null;
     }
 }

public class DiameterOfBinTree {
   
   //approach-1  TC=>O(n*n)
    // public static int height(TreeNode<Integer> root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftHeight = height(root.left);
    //     int rightHeight = height(root.right);
    //     return Math.max(leftHeight, rightHeight) + 1;
    // }
    // public static int diameterOfBinaryTree(TreeNode<Integer> root) {
    //     // Write your code here.
    //    if (root == null) {
    //         return 0;
    //     }

    //     // Calculate the height of the left and right subtrees
    //     int leftHeight = height(root.left);
    //     int rightHeight = height(root.right);

    //     // Calculate the diameter recursively for left and right subtrees
    //     int leftDiameter = diameterOfBinaryTree(root.left);
    //     int rightDiameter = diameterOfBinaryTree(root.right);

    //     // Diameter can be in either the left subtree, right subtree, or crossing the root
    //     return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    // }

    //approach-2 tc=>[O(n)]
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair solve(BinaryTreeNode<Integer> left2) {
        if (left2 == null) {
            Pair p = new Pair(-1, -1);
            return p;
        }

        Pair left = solve(left2.left);
        Pair right = solve(left2.right);

        int op1 = left.first;
        int op2 = right.first;
        int op3 = left.second + right.second + 1;

        Pair ans = new Pair(Math.max(op1, Math.max(op2, op3)), Math.max(left.second, right.second) + 1);
        return ans;
    }

    private static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        Pair result = solve(root);
        return result.first + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        // Add more nodes as needed

        int diameter = diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }

    
}