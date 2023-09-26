/*
 * problem statement:
 You are given an arbitrary binary tree consisting of N nodes where each node is associated with a certain value. You need to check whether the given tree is a sum tree or n
 */

import java.util.* ;


import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T val) 
        {
            this.val = val;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution 
{

    public static boolean leaf(TreeNode<Integer> node) {
        if(node==null) {
            return false;
        } 
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    public static boolean isSumTree(TreeNode<Integer> root)
    {
        //    Write your code here.

        /*
            Time Complexity: O(N)
            Explanation: The code will run for every new node, so the time complexity is O(N).

            Space Complexity: O(N)
            Explanation: In this approach, space is needed for every node, so the space complexity is O(N).
        */
        int ls, rs;

        if(root == null || leaf(root) == true) {
            return true;
        }

        if(isSumTree(root.left) == true && isSumTree(root.right)) {
            if(root.left == null) {
                ls = 0;
            } else if(leaf(root.left) == true) {
                ls = root.left.val;
            } else {
                ls = 2 * (root.left.val);
            }
            if(root.right == null) {
                rs = 0;
            } else if(leaf(root.right) == true) {
                rs = root.right.val;
            } else {
                rs = 2 * (root.right.val);
            }
            return root.val == ls+rs;
        }
        return false;
    }
}

