import java.util.*;
public class Solution {

	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }
       
        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt += size; 
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int j = 0;j<4;j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || 
                    grid[x][y] == 2) continue;
                    
                    grid[x][y] = 2;
                    queue.offer(new int[]{x , y});
                }
            }
            if(queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
	}

}

/*
 Time Complexity:
Let's analyze the time complexity of the provided Java code:

The nested loops iterating over each cell in the grid contribute O(N * M), where N is the number of rows and M is the number of columns.
The while loop that performs BFS has a time complexity proportional to the number of cells in the grid. In the worst case, each cell is visited once, so this contributes O(N * M).
Therefore, the overall time complexity is O(N * M).

Space Complexity:
Let's analyze the space complexity:

The space used by the Queue<int[]> is proportional to the number of rotten oranges. In the worst case, all rotten oranges are initially in the queue. So, the space complexity for the queue is O(N * M).
Other integer variables and arrays used in the code have constant space complexity.
Therefore, the overall space complexity is O(N * M).
 */