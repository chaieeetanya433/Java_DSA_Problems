import java.util.*;

/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/

public class Solution
{
    /*
      the time complexity of both methods is O(N), and the space complexity is O(W + N), where N is the number of nodes in the tree, and W is the maximum width of the tree (number of nodes at the maximum level)
     */
	 // Create mapping and return target node
    public static BinaryTreeNode<Integer> createParentMapping(BinaryTreeNode<Integer> root, int target, HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> nodeToParent) {
        BinaryTreeNode<Integer> res = null;

        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> front = q.poll();

            if (front.data == target) {
                res = front;
            }

            if (front.left != null) {
                nodeToParent.putIfAbsent(front.left, front);
                q.offer(front.left);
            }

            if (front.right != null) {
                nodeToParent.putIfAbsent(front.right, front);
                q.offer(front.right);
            }
        }
        return res;
    }

    // Return the time required to burn the tree
    public static int burnTree(BinaryTreeNode<Integer> targetNode, HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> nodeToParent) {
        HashMap<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

        q.offer(targetNode);
        visited.put(targetNode, true);

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // Process neighboring nodes
                BinaryTreeNode<Integer> front = q.poll();

                if (front.left != null && !visited.containsKey(front.left)) {
                    q.offer(front.left);
                    visited.put(front.left, true);
                }
                if (front.right != null && !visited.containsKey(front.right)) {
                    q.offer(front.right);
                    visited.put(front.right, true);
                }
                if (nodeToParent.containsKey(front) && !visited.containsKey(nodeToParent.get(front))) {
                    q.offer(nodeToParent.get(front));
                    visited.put(nodeToParent.get(front), true);
                }
            }
            ans++;
        }
        return ans - 1; // Subtract 1 to exclude the initial target node
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        // Step 1: Create nodeToParent mapping
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> nodeToParent = new HashMap<>();
        BinaryTreeNode<Integer> targetNode = createParentMapping(root, start, nodeToParent);

        // Step 2: Burn the tree in minimum time
        int ans = burnTree(targetNode, nodeToParent);

        return ans;
    }
}