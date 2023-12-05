import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first, second, third;
    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class Solution {
    public static int savingMoney(int n, int source, int destination, int k, List<List<Integer>> trains) {
        // Write your code here.

        //create the adjacency list to depict stations and trains in 
        //the form of a graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = trains.size();
        for(int i=0; i<m; i++) {
            adj.get(trains.get(i).get(0)).add(new Pair(trains.get(i).get(1), trains.get(i).get(2)));
        }

        //create a queue which stores the node and their distances from the 
        //source in the form of {stops, {node, dist}} with 'stops' indicating
        //the no. of nodes between src and current node
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, source, 0));

        //distance array to store the updated distances from the source
        int[] dist = new int[n];
        for(int i=0; i<n; i++) {
            dist[i] = (int)(1e9);
        }

        dist[source] = 0;

        //iterate through the graph using a queue like in dijkstra with 
        //popping out the element with min stops first
        while(!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            //we stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue;
            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                //we only update the queue if the new calculated dist is 
                //less than the prev and the stops are also within limits.
                if(cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost+edW));
                }
            }
        }
        //if the destination node is unreachable return -1
        //else return the calculated dist from src to dst;
        if(dist[destination] == (int)(1e9)) return -1;
        return dist[destination];
    }
}
/*
Time Complexity:
The time complexity of this code is determined by the breadth-first search (BFS) traversal through the graph. In the worst case, the algorithm visits each node and each edge once. Therefore, the overall time complexity is O(V + E), where V is the number of vertices (stations) and E is the number of edges (trains).

In this specific code, the outer loop iterates through all nodes in the graph (n iterations), and the inner loop iterates through the adjacent nodes of each node in the graph (m iterations, where m is the number of trains). Therefore, the overall time complexity is O(n + m).

Space Complexity:
The space complexity is determined by the space used for storing the graph adjacency list, the queue, and the distance array.

Graph Adjacency List (adj): The space complexity for the adjacency list is O(V + E), where V is the number of vertices and E is the number of edges. In this case, it is O(n + m).

Queue (q): In the worst case, the queue can contain all nodes in the graph. Therefore, the space complexity for the queue is O(V), where V is the number of vertices. In this case, it is O(n).

Distance Array (dist): The space complexity for the distance array is O(V), where V is the number of vertices. In this case, it is O(n).

Combining all the space complexities, the overall space complexity is O(n + m).
*/