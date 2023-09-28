import java.util.*;


/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/
class Pair<T, U> {
    T key;
    U value;

    Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    T getKey() {
        return key;
    }

    U getValue() {
        return value;
    }
}

public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        HashMap<Integer, Integer> topNode = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> temp = q.poll();
            TreeNode frontNode = temp.getKey();
            int hd = temp.getValue(); // Change getKey() to getValue()

            if (!topNode.containsKey(hd)) { // Check if hd is not in topNode
                topNode.put(hd, frontNode.data);
            }

            if (frontNode.left != null) {
                q.offer(new Pair<>(frontNode.left, hd - 1)); // Fix this line
            }
            if (frontNode.right != null) {
                q.offer(new Pair<>(frontNode.right, hd + 1)); // Fix this line
            }
        }

        // Sort the keys to get them in order
        List<Integer> sortedKeys = new ArrayList<>(topNode.keySet());
        Collections.sort(sortedKeys);

        for (int key : sortedKeys) {
            ans.add(topNode.get(key));
        }

        return ans;
    }
}
