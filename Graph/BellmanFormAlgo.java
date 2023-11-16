import java.util.*;

public class BellmanFormAlgo {
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
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -10));
    }

    public static int[] BellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //O(v)
        for(int i=0; i<graph.length-1; i++) {
            //edges - O(E)
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                        dist[v] = dist[u]+wt;
                    }
                }
            }

            //detecting negative weight cycle
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                        System.out.print("Negative weight cycle exits");
                        break;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int ans[] = BellmanFord(graph, 0);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

/*
 Time Complexity:

The outer loop runs V−1 times, where 

V is the number of vertices. Inside this loop, there are two nested loops:
The first inner loop runs through all vertices.
The second inner loop runs through all edges.
Therefore, the overall time complexity is O(V⋅E), where V is the number of vertices, and E is the number of edges in the graph.

Space Complexity:

The space complexity is dominated by the data structures used to store the graph, and the array dist to store the distances. The space complexity is O(V+E).
 */
