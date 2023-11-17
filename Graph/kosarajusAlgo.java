import java.util.*;

public class kosarajusAlgo {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, Stack<Integer> st, boolean vis[]) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, st, vis);
            }
        }

        st.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    public static void kosarajusAlgo(ArrayList<Edge> graph[], int V) {
        // step1-get nodes in the stack(topological sort) tc = O(V+E)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, s, vis);
            }
        }

        // step2- transpose the graph, tc = O(v+e)
        ArrayList<Edge> transposeGraph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            transposeGraph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            vis[i] = false;
            for (int j = 0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transposeGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step-3-do dfs according to stack nodes on the transposed graph = O(O+v)
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC: ");
                dfs(transposeGraph, vis, curr);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosarajusAlgo(graph, V);
    }
}

/*
 Time Complexity:
Creating the Graph (createGraph method):

Time Complexity: O(V), where V is the number of vertices.
Topological Sort (topSort method):

Time Complexity: O(V + E), where V is the number of vertices, and E is the number of edges. This is because each vertex and each edge are processed once.
Transposing the Graph (kosarajusAlgo method):

Time Complexity: O(V + E), where V is the number of vertices, and E is the number of edges. This is because each edge is processed once.
Performing DFS on Transposed Graph (dfs method inside kosarajusAlgo):

Time Complexity: O(V + E), where V is the number of vertices, and E is the number of edges. In the worst case, each vertex and each edge are processed once.
The overall time complexity is dominated by the topological sort step, so the total time complexity is O(V + E).

Space Complexity:
Graph Representation:

The space required to represent the graph using an adjacency list is O(V + E), where V is the number of vertices, and E is the number of edges.
Stack for Topological Sort (topSort method):

The space required for the stack is O(V), where V is the number of vertices (worst case when all vertices are pushed onto the stack).
Transpose Graph Representation:

The space required to represent the transposed graph using an adjacency list is also O(V + E).
Boolean Array for Visited Nodes:

The space required for the boolean array to mark visited nodes is O(V).
The overall space complexity is O(V + E).
 */
