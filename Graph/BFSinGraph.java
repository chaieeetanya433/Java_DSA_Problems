import java.util.*;
public class Solution {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        // Write your code here
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                ans.add(curr);
                vis[curr] = true;
                for (int neighbor : adj.get(curr)) {
                    q.add(neighbor); // neighbor vertex
                }
            }
        }

        return ans;
    }
}

