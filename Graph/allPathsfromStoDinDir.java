import java.util.*;

public class allPathsfromStoDinDir {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void printAllPaths(ArrayList<Edge> graph[], boolean[] vis, int curr, String path, int tar)  {
        //base case
        if(curr == tar) {
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[curr] == false) {
                vis[curr] = true;
                printAllPaths(graph, vis, e.dest, path+e.dest, tar);
                vis[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int V = 7, tar=5;
        boolean vis[] = new boolean[V];
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        printAllPaths(graph, vis, 0, "0", tar);
    }
}
