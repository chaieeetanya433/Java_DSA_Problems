import java.util.*;

class Node {
    int first;
    int second;
    int third;

    Node(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

public class Solution {
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int[][] vis = new int[n][m];
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            dist.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
                dist.get(i).add(0); // Initialize distance matrix with zeros
            }
        }

        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();

            dist.get(row).set(col, steps);

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }
        return dist;
    }
}


/*

Space Complexity:
Input Space:

The input matrix mat is not explicitly stored in any additional data structures. It is directly accessed in the code.
The space complexity for the input matrix is O(n * m), where n is the number of rows and m is the number of columns.
Auxiliary Space:

The space complexity is dominated by the auxiliary data structures used during the BFS traversal.
The vis array is used to keep track of visited nodes, and its space complexity is O(n * m).
The dist matrix is used to store the distances from the 1-valued nodes to other nodes, and its space complexity is also O(n * m).
The q queue can have at most O(n * m) elements in the worst case.
Total Space Complexity:

O(n * m) + O(n * m) + O(n * m) + O(n * m) ≈ O(n * m).
Time Complexity:
BFS Traversal:
In the worst case, each cell is visited once, and each edge is traversed once during the BFS traversal.
The BFS traversal has a time complexity of O(V + E), where V is the number of vertices (cells) and E is the number of edges (connections between cells).
In this case, V ≈ n * m, and E ≈ 4 * n * m (considering each cell has four neighbors in a grid).
So, the time complexity of BFS is O(n * m).
 */