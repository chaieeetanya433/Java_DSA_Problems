
public class Solution{

    public static void dfs(int row, int col, int vis[][], char mat[][], int drow[], int dcol[]) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        //check for top, right, left, and bottom
        for(int i=0; i<4; i++) {
            int nrow = row+drow[i];
            int ncol = col+dcol[i];

            //check for valid coordinates and unvisited Os
            if(nrow >= 0 && nrow < n && ncol>=0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, drow, dcol);
            }
        }
    }
    public static void replaceOWithX(char matrix[][]) {
        // write your code here
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int n = matrix.length;
        int m = matrix[0].length;
        int vis[][] = new int[n][m];

        //traverse the first row and last row
        for(int j=0; j<m; j++) {
            //traverse first row
            if(vis[0][j] == 0 && matrix[0][j] == 'O') {
                dfs(0, j, vis, matrix, drow, dcol);
            }
            //traverse last row
            if(vis[n-1][j] == 0 && matrix[n-1][j] == 'O') {
                dfs(n-1, j, vis, matrix, drow, dcol);
            }
        }
        //traverse the first col and last col
        for(int i=0; i<n; i++) {
            //traverse first col
            if(vis[i][0] == 0 && matrix[i][0] == 'O') {
                dfs(i, 0, vis, matrix, drow, dcol);
            }
            //traverse last col
            if(vis[i][m-1] == 0 && matrix[i][m-1] == 'O') {
                dfs(i, m-1, vis, matrix, drow, dcol);
            }
        }

        //if unvisited 0 then convert to X
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(vis[i][j] == 0 && matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                }
            }
        }
    }
}

/*
 Time Complexity:
DFS Traversal:

In the worst case, each cell is visited once, and each edge is traversed once during the DFS traversal.
The DFS traversal has a time complexity of O(V + E), where V is the number of vertices (cells) and E is the number of edges (connections between cells).
In this case, V ≈ n * m, and E ≈ 4 * n * m (considering each cell has four neighbors in a grid).
So, the time complexity of DFS is O(n * m).
Main Function (replaceOWithX):

The main function consists of several loops, each iterating through rows and columns.
The loops have a time complexity of O(n + m) because they traverse each row and each column once.
The DFS traversal is called in these loops, contributing to the overall time complexity.
So, the overall time complexity is O((n + m) * n * m) ≈ O(n^2 * m + n * m^2).
Space Complexity:
Auxiliary Space (vis array):

The vis array is used to keep track of visited nodes, and its space complexity is O(n * m).
Other Variables:

The space complexity for other variables (drow, dcol, n, m, etc.) is constant and does not depend on the input size.
Total Space Complexity:

O(n * m).
 */