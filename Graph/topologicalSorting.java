import java.util.ArrayList;
import java.util.Stack;

public class topologicalSorting {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    //time complexity => O(V+E)
    //space complexity => O(N)
    public static void topSortUtil(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> st) {
        vis[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false) {
                topSortUtil(graph, vis, e.dest, st);
            }
        }

        st.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[], int V) {
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++) {
            if(vis[i] == false) {
                topSortUtil(graph, vis, i, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        topSort(graph, V);
    }
}
