import java.util.* ;
import java.io.*; 
public class Solution {
      public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }

        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] != null) {
                for (int it : edges[i]) {
                    adjRev.get(it).add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Check for cycles
        for (int i = 0; i < n; i++) {
            if (indegree[i] > 0) {
                // Node i is part of a cycle, mark it as unsafe
                safeNodes.remove(Integer.valueOf(i));
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}

/*
Time Complexity:
Building the Reverse Adjacency List:

The loop that creates the reverse adjacency list runs for each node in the graph, taking O(n) time.
The nested loop that processes the edges contributes O(e) time, where 'e' is the number of edges.
Overall, building the reverse adjacency list has a time complexity of O(n + e).
Topological Sorting using BFS:

The BFS traversal processes each node and edge once, contributing O(n + e) time complexity.
Sorting the Result:

Sorting the result array takes O(n * log(n)) time.
The overall time complexity of the solution is dominated by the steps mentioned above, and it can be expressed as O(n + e + n * log(n)), which simplifies to O(n + e + n * log(n)).

Space Complexity:
Reverse Adjacency List:

The space required for the reverse adjacency list is O(n + e) as we store each edge once in the adjacency list.
Indegree Array and Queue:

The indegree array and the queue used in BFS both require O(n) space.
Result Array:

The result array requires O(n) space.
The overall space complexity is O(n + e).
*/