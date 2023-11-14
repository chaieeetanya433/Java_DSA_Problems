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
    private static void bfs(int ro, int co, int[][] vis, int[][] grid) {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        // until the queue becomes empty
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // traverse in the neighbours and mark them if its a land
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    // check if neighbour row and column is valid, and is an unvisited land
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                            && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public static int distinctIsland(int[][] arr, int n, int m) {
        // write your code here
        int[][] vis = new int[n][m];
        int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // if not visited and is a land
                if (vis[row][col] == 0 && arr[row][col] == 1) {
                    cnt++;
                    bfs(row, col, vis, arr);
                }
            }
        }
        return cnt;

    }
}

/*
 Time Complexity:
The time complexity is determined by the BFS (Breadth-First Search) algorithm inside the bfs method. In the worst case, each cell of the grid is visited once, and for each cell, we traverse its neighbors. Therefore, the time complexity is O(N * M), where N is the number of rows and M is the number of columns in the grid.

Space Complexity:
The space complexity is determined by the space used for the Queue<Pair> and the vis array. In the worst case, all cells might be added to the queue, and the vis array keeps track of whether a cell has been visited or not.

The space used by the Queue<Pair>: In the worst case, all land cells are added to the queue. The maximum number of land cells that can be in the queue at the same time is bounded by the size of the grid, so the space complexity is O(N * M).

The space used by the int[][] vis array: This array keeps track of visited cells. Its size is equal to the size of the grid. Therefore, the space complexity for this array is O(N * M).

Combining both contributions, the overall space complexity is O(N * M).
 */