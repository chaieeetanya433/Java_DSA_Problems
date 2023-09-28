import java.util.* ;
import java.io.*; 
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


public class Solution 
{
    public static void solve(TreeNode<Integer> root, ArrayList<Integer> ans, int level) {
        //base case
        if(root == null) {
            return;
        }

        //we entered into a new level
        if(level == ans.size()) {
            ans.add(root.data);
        }

        solve(root.left, ans, level+1);
        solve(root.right, ans, level+1);
    }
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, ans, 0);
        return ans;
    }
}
