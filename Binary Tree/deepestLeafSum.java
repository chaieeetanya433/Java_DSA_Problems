import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Tree node structure:
		
    class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) 
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

************************************************************/
/*
 Time Complexity:

Each node is visited once in the while loop.
The while loop runs in O(N) time, where N is the number of nodes in the tree.
Space Complexity:

The space complexity is dominated by the queue and hashmap.
In the worst case, all nodes at the last level will be enqueued, leading to O(N) space usage in the queue.
The hashmap also uses O(N) space as it stores the mapping of each node to its level.
 */

 /*
  steps:
  1. Initialize the Queue and HashMap:
Create a queue (q) to perform a level-order traversal.
Create a hashmap (mp) to store the level of each node.
2. Initialize Variables:
Initialize level and sum variables to keep track of the current deepest level and the sum of nodes at that level.
3. Enqueue the Root Node:
If the root node is not null, enqueue it into the queue and set its level in the hashmap.
4. Perform Level-Order Traversal:
Use a while loop to iterate while the queue is not empty.
Dequeue a node (current) and its level (currentLvl) from the queue.
5. Update Sum and Level:
If a new level is encountered, update the sum and level variables.
If still on the same level, add the node's value to the sum
6. Enqueue Left and Right Children:
Enqueue the left and right children of the current node with an increased level.
7. Return the Sum:
After the while loop, the sum variable holds the sum of leaf nodes at the deepest level. Return this value.
  */

public class Solution {
    public static int levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        HashMap<TreeNode, Integer> mp = new HashMap<>();
        int level = 0, sum = 0;

        if (root != null) {
            q.add(root);  // Enqueue the root node initially
            mp.put(root, level);
        }

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            int currentLvl = mp.get(current);

            if (currentLvl > level) {
                // if a new Level is encountered, update the sum and level
                sum = current.val;
                level = currentLvl;
            } else {
                // if still on the same level, add to the sum
                sum += current.val;
            }

            // enqueue left and right children with increased level
            if (current.left != null) {
                q.add(current.left);
                mp.put(current.left, currentLvl + 1);
            }
            if (current.right != null) {
                q.add(current.right);
                mp.put(current.right, currentLvl + 1);
            }
        }
        return sum;
    }

    public static int deepestLeavesSum(TreeNode root) {
        // Write your code here.
        if (root == null) {
            return 0;
        }

        return levelOrderTraversal(root);
    }
}