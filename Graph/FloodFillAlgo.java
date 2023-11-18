import java.util.*;

public class Solution
{
    private static void dfs(int row, int col, int[][] ans, int[][] image, int newColor,
    int drow[], int dcol[], int iniColor) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++) {
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
            image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, drow, dcol, iniColor);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        // Write your code here
        int iniColor = image[x][y];
        int[][] ans = image;
        //upper neighbour - (row-1, col)
        //lower neighbour - (row+1, col)
        //right neighbour - (row, col+1)
        //left neighbour - (row, col-1)
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, 0, -1};
        dfs(x, y, ans, image, newColor, drow, dcol, iniColor);
        return ans;
    }
}

/*
Time Complexity:
The time complexity of the dfs function depends on the size of the grid (image) and the connectivity of the pixels. In the worst case, the DFS algorithm might visit every pixel in the grid. If the grid has dimensions n (number of rows) and m (number of columns), and every pixel is reachable from every other pixel, then the time complexity would be O(n * m).

Space Complexity:
The space complexity is determined by the depth of the recursion stack in the dfs function. In the worst case, the recursion depth could be as large as the number of pixels in the grid. Therefore, the space complexity is O(n * m).

It's worth noting that the space complexity is not only influenced by the recursion stack but also by the additional space used for the arrays drow and dcol, which have a constant size (4 elements each). Asymptotically, however, the dominant factor is the recursion stack when considering the space complexity.
*/

