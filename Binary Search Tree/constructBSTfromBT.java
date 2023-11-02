import java.util.ArrayList;
import java.util.Collections;

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

public class Solution {
    public static void inOrder(BinaryTreeNode<Integer> root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    public static BinaryTreeNode<Integer> bstFromInorder(ArrayList<Integer> inOrder, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(inOrder.get(mid));

        root.left = bstFromInorder(inOrder, left, mid - 1);
        root.right = bstFromInorder(inOrder, mid + 1, right);

        return root;
    }

    public static BinaryTreeNode<Integer> binaryTreeToBst(BinaryTreeNode<Integer> root) {
        // Create an ArrayList to store the inorder traversal elements
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        // Sort the ArrayList to get the elements in ascending order
        Collections.sort(arr);

        // Convert the sorted array to a BST
        return bstFromInorder(arr, 0, arr.size() - 1);
    }

    public static void printInorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Input Binary Tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(15);
        root.left = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(20);
        root.left.left = new BinaryTreeNode<>(8);
        root.left.right = new BinaryTreeNode<>(12);
        root.right.left = new BinaryTreeNode<>(16);
        root.right.right = new BinaryTreeNode<>(25);

        System.out.println("Original Binary Tree Inorder:");
        printInorder(root);
        System.out.println();

        BinaryTreeNode<Integer> bstRoot = binaryTreeToBst(root);

        System.out.println("BST Inorder:");
        printInorder(bstRoot);
    }
}
