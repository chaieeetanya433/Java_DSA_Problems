import java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure.
    
    class BinaryTreeNode<T> {
	      T data;
	      BinaryTreeNode<T> left;
	      BinaryTreeNode<T> right;
 
	      BinaryTreeNode(T data) {
	          this.data = data;
	          left = null;
	          right = null;
	      }
	}
    
*************************************************************/


public class Solution {
    /*
     the time complexity is O(nh) in the worst case and may be closer to O(nlog(n)) in more balanced trees, while the space complexity is O(n) in the worst case.
     */

	public static void solve(BinaryTreeNode<Integer> root, int k, ArrayList<ArrayList<Integer>> path, ArrayList<Integer> ans) {
        // base case
        if (root == null) {
            return;
        }

        ans.add(root.data);

        // left
        solve(root.left, k, path, ans);

        // right
        solve(root.right, k, path, ans);

        // Create a new ArrayList to store the current path.
        ArrayList<Integer> currentPath = new ArrayList<>(ans);

        // check for k sum
        int sum = 0;
        for (int i = currentPath.size() - 1; i >= 0; i--) {
            sum += currentPath.get(i);
            if (sum == k) {
                // Add a new ArrayList with the current path to the result.
                path.add(new ArrayList<>(currentPath.subList(i, currentPath.size())));
            }
        }

        ans.remove(ans.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> kPathSum(BinaryTreeNode<Integer> root, int k) {
        ArrayList<ArrayList<Integer>> path = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, k, path, ans);
        return path;
    }
}

