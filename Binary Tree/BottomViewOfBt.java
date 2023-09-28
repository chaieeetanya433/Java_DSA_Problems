import java.util.*;
/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
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
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here. 
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        HashMap<Integer, Integer> BottomTopNode = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> temp = q.poll();
            TreeNode frontNode = temp.getKey();
            int hd = temp.getValue(); // Change getKey() to getValue()

           
            BottomTopNode.put(hd, frontNode.val);
            

            if (frontNode.left != null) {
                q.offer(new Pair<>(frontNode.left, hd - 1)); // Fix this line
            }
            if (frontNode.right != null) {
                q.offer(new Pair<>(frontNode.right, hd + 1)); // Fix this line
            }
        }

        // Sort the keys to get them in order
        List<Integer> sortedKeys = new ArrayList<>(BottomTopNode.keySet());
        Collections.sort(sortedKeys);

        for (int key : sortedKeys) {
            ans.add(BottomTopNode.get(key));
        }

        return ans;        
    }
}
