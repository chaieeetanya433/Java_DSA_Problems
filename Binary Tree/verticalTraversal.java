/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
         the time complexity of the code is O(n * log n), and the space complexity is O(n). The time complexity is primarily affected by the insertion and sorting operations in the TreeMap, while the space complexity is determined by the space used by the queue, TreeMap, and the output list.
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
          TreeMap<Integer, TreeMap<Integer, List<Integer>>> nodes = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        q.offer(new Pair<>(root, new Pair<>(0, 0))); // Use offer() instead of push() to enqueue.

        while (!q.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> temp = q.poll(); // Use poll() to dequeue.

            TreeNode frontNode = temp.getKey();
            int hd = temp.getValue().getKey();
            int lvl = temp.getValue().getValue();

            // If the hd doesn't exist in the TreeMap, create a new one.
            nodes.putIfAbsent(hd, new TreeMap<>());
            // If the lvl doesn't exist in the hd's TreeMap, create a new one.
            nodes.get(hd).putIfAbsent(lvl, new ArrayList<>());
            // Add the node's value to the corresponding hd and lvl.
            nodes.get(hd).get(lvl).add(frontNode.val);

            if (frontNode.left != null) {
                q.offer(new Pair<>(frontNode.left, new Pair<>(hd - 1, lvl + 1)));
            }
            if (frontNode.right != null) {
                q.offer(new Pair<>(frontNode.right, new Pair<>(hd + 1, lvl + 1)));
            }
        }

        // Traverse the TreeMap and extract the results into ans.
        for (TreeMap<Integer, List<Integer>> lvlMap : nodes.values()) {
            List<Integer> levelResult = new ArrayList<>();
            for (List<Integer> nodeVals : lvlMap.values()) {
                Collections.sort(nodeVals); // Sort nodes at the same hd and lvl.
                levelResult.addAll(nodeVals);
            }
            ans.add(levelResult);
        }

        return ans;
    }
}