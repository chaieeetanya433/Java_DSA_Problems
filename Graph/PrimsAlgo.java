import java.util.*;

public class PrimsAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int n, int cost) {
            this.node = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));

        int mincost = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;
                mincost += curr.cost;
                for(int i=0; i<graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Min cost of mst : "+mincost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primsAlgo(graph, V);
    }
}


/*
 Time Complexity:
The time complexity of Prim's algorithm depends on the data structures used for the priority queue and whether the graph is represented as an adjacency matrix or an adjacency list.

Priority Queue Operations:

The priority queue operations dominate the time complexity.
In the worst case, each edge is added to the priority queue once.
The worst-case time complexity for adding an edge to the priority queue is O(logV).
So, the overall time complexity is (ElogV), where E is the number of edges and V is the number of vertices.
Overall Time Complexity:
The overall time complexity is often O(ElogV) when using a binary heap-based priority queue.
If using more advanced data structures like Fibonacci heap, the time complexity can be improved to O(E+VlogV).
Space Complexity:
The space complexity of the algorithm is influenced by the data structures used to represent the graph and maintain the priority queue.

Graph Representation:

For an adjacency list representation, the space complexity is O(V+E), where V is the number of vertices and E is the number of edges.
For an adjacency matrix representation, the space complexity is O(V^2).
Priority Queue:
The space complexity for the priority queue is O(V).
Boolean Array:
The boolean array to track visited nodes has a space complexity of O(V).
Overall Space Complexity:
The overall space complexity is O(V+E) for an adjacency list representation.
 */
