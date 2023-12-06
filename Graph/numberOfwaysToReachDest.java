import java.util.*;

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public static int numberOfWays(int n, int m, int[][] edges) {
        // Write your code here

        //creating an adjacency list for the given graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        //defining a priority queue (min heap)
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

        //Initializing the dist array and the ways array
        //along with their first indices
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        //define module value
        int mod = (int) (1e9 + 7);

        //Iterate through the graph with the help of prority queue
        //just as we do in Dijkstra's algo
        while (pq.size() != 0) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // this 'if' condition signifies that this is the first
                // time we're coming with this short distance, so we push
                // in PQ and keep the no. of ways the same
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                }

                // if we again encounter a node with the same short distance
                // as before, we simply increment the no. of ways
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7
        return ways[n - 1] % mod;
    }
}

/*
 Time Complexity: O( E* log(V)) { As we are using simple Dijkstra’s algorithm here, the time complexity will be or the order E*log(V)}

Where E = Number of edges and V = No. of vertices.

Space Complexity :  O(N) { for dist array + ways array + approximate complexity for priority queue }

Where, N = Number of nodes.
 */
