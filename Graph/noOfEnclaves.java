import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

public class Solution {
    public static int matrixTraps(int n,int m, int [][]Matrix) {
        // Write your code here.
        Queue<Pair> q = new LinkedList<Pair>();
        int vis[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                //first row, first col, last row, last col
                if(i==0 || j==0 || i==n-1 || j==m-1) {
                    if(Matrix[i][j] == 0) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, 0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            //traverse all 4 directions
            for(int i=0; i<4; i++) {
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && Matrix[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(Matrix[i][j] == 0 && vis[i][j] == 0) cnt++; 
            }
        }
        return cnt;
    }
}

/*

Time Complexity:

The time complexity is determined by the breadth-first search (BFS) traversal of the matrix. In the worst case, each cell of the matrix is visited once. For each cell, we explore its neighbors, which takes constant time. Therefore, the overall time complexity is O(N * M), where N is the number of rows, and M is the number of columns in the matrix.

Space Complexity:

The space complexity is determined by the space used for the queue (q) and the visited array (vis). In the worst case, all cells of the matrix could be added to the queue, so the space complexity is O(N * M) for the queue. Additionally, the visited array has a space complexity of O(N * M) since we mark each cell as visited or not visited. Therefore, the overall space complexity is O(N * M).


*/