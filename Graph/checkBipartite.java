import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

    private static int findNumberOfVertices(ArrayList<ArrayList<Integer>> edges) {
        HashSet<Integer> vertices = new HashSet<>();

        for (ArrayList<Integer> edge : edges) {
            vertices.addAll(edge);
        }

        return vertices.size();
    }

    private static boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean isGraphBipartite(ArrayList<ArrayList<Integer>> edges) {
        int V = findNumberOfVertices(edges);
        int color[] = new int[V];

        for (int i = 0; i < V; i++)
            color[i] = -1;

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, edges))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1, 0, 0)));
        edges.add(new ArrayList<>(List.of(0, 0, 0, 1)));
        edges.add(new ArrayList<>(List.of(0, 0, 0, 0)));
        edges.add(new ArrayList<>(List.of(0, 0, 0, 0)));

        System.out.println(isGraphBipartite(edges));
    }
}
