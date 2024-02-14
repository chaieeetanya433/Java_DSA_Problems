import java.util.*;

public class Solution {

    //recursive approach 
    /*public static int f(int day, int last, int points[][]) {
        if(day == 0) {
            int maxi = 0;
            for(int task=0; task<3; task++) {
                if(task != last) {
                    maxi = Integer.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for(int task=0; task<3; task++) {
            if(task != last) {
                int point = points[day][task] + f(day-1, task, points);
                maxi = Integer.max(maxi, point);
            }
        }
        return maxi;
    }*/

    //memoization approach
    /*
        Time Complexity: O(N*4*3)

      Reason: There are N*4 states and for every state, we are running a for loop iterating three times.

      Space Complexity: O(N) + O(N*4)

      Reason: We are using a recursion stack space(O(N)) and a 2D array (again O(N*4)). Therefore total space complexity will be O(N) + O(N) ≈ O(N)
    */
    /*public static int f(int day, int last, int[][] points, int[][] dp) {
        // If the result is already calculated, return it
        if (dp[day][last] != -1) return dp[day][last];

        // Base case: When it's the first day (day == 0)
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi; // Store and return the result
        }

        int maxi = 0;
        // Loop through the three activities on the current day
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                // Calculate the points for the current activity and recursively
                // calculate the maximum points for the previous day
                int activity = points[day][i] + f(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity); // Update the maximum points
            }
        }

        return dp[day][last] = maxi; // Store and return the result
    }*/



    // public static int ninjaTraining(int n, int points[][]) {
    //     // Write your code here..
    //     int[][] dp = new int[n][4];
    //     for (int[] row : dp)
    //         Arrays.fill(row, -1);

    //     return f(n-1, 3, points, dp);
    // }

    //tabulation approach;
    /*
      Time Complexity: O(N*4*3)

    Reason: There are three nested loops

    Space Complexity: O(N*4)

    Reason: We are using an external array of size ‘N*4’’.
    */
    /*public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
         int[][] dp = new int[n][4];
        
        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }*/

    //space optimized approach
    /*Time Complexity: O(N*4*3)

  Reason: There are three nested loops

  Space Complexity: O(4)

  Reason: We are using an external array of size ‘4’ to store only one row.*/
     public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int prev[] = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day starting from the second day
        for (int day = 1; day < n; day++) {
            // Initialize an array 'temp' to store the maximum points for the current day
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            // Update 'prev' to store the maximum points for the current day
            prev = temp;
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return prev[3];
    }

}
