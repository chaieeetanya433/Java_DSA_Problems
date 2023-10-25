import java.util.* ;
import java.io.*; 
/*
 we'll be given a key. we need to find the closest possible value which is greater than equal to the key
 */
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;4
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

public class Solution {
    //tc = O(2logn);

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        int ceil = -1;
        while(node != null) {
            if(node.data == x) {
                ceil = node.data;
                return ceil;
            }   
            if(x > node.data) {
                node = node.right;                 
            } else {
                ceil = node.data;
                node = node.left;              
            }
        }
        return ceil;
    }
}

