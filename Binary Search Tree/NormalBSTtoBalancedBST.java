import java.util.*;

/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
//tc=>O(n) and sc=>O(n)
public class Solution 
{
    public static void inOrder(TreeNode<Integer> root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }
    public static TreeNode<Integer> inOrderToBST(int s, int e, ArrayList<Integer> inOrderVal) {
        //base case
        if(s > e) {
            return null;
        }

        int mid = (s+e)/2;
        TreeNode<Integer> root = new TreeNode<>(inOrderVal.get(mid));
        root.left = inOrderToBST(s, mid-1, inOrderVal);
        root.right = inOrderToBST(mid+1, e, inOrderVal);
        return root;
    }

    public static TreeNode<Integer> balancedBst(TreeNode<Integer> root)
    {
        //    Write your code here.
        ArrayList<Integer> inOrderVal = new ArrayList<>();

        inOrder(root, inOrderVal);

        return inOrderToBST(0, inOrderVal.size()-1, inOrderVal);
    }

}