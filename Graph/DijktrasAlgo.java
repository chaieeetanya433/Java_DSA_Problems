import java.util.*;

public class DijktrasAlgo {
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int n, int path) {
            this.node = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static int[] dijktra(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(!vis[v] && dist[u]+e.wt < dist[v]) {
                        dist[v] = dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int ans[] = dijktra(graph, 0);

        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}

/*
 Time Complexity:
The time complexity of the Dijkstra's algorithm is influenced by the operations performed in the priority queue and the iteration through the edges. Let V be the number of vertices and E be the number of edges in the graph.

1. Priority Queue Operations: The main loop involves extracting the minimum element from the priority queue (O(log⁡ V))
O(logV) for each extraction). Since each vertex is added to the priority queue at most once, the total time spent on priority queue operations is 
O(VlogV).

2. Iterating Through Edges: In the worst case, each edge is considered once. So, iterating through all edges contributes O(E) to the time complexity.

Therefore, the overall time complexity of the provided Dijkstra's algorithm is 
O((V+E)logV).

Space Complexity:
The space complexity is determined by the data structures used to store information about vertices and edges.

Priority Queue: The priority queue can have at most V elements, contributing O(V) to the space complexity.

Arrays for Distances and Visited Nodes: Arrays dist and vis are used to store distances and track visited nodes, respectively. Both arrays have a size of V, contributing O(V) to the space complexity.

Graph Representation: The graph is represented using an adjacency list. In the worst case, each edge is stored once for each of its vertices. So, the space required for the graph representation is O(E+V).

Therefore, the overall space complexity of the provided Dijkstra's algorithm is O(V+E).
 */
