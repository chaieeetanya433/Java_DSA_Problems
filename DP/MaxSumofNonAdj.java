import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {

	//recursive approach with O(2^n) 
	/*public static int f(int indx, ArrayList<Integer> nums) {
		if(indx == 0) return nums.get(indx);
		if(indx < 0) return 0;

		int pick = nums.get(indx) + f(indx-2, nums);
		int notpick = 0 + f(indx-1, nums);

		return Integer.max(pick, notpick);				
	}*/

	//Memoization approach with O(N) tc and O(n)+O(n) sc
	/*public static int f(int indx, ArrayList<Integer> nums, int[] dp) {
		if(indx == 0) return nums.get(indx);
		if(indx < 0) return 0;

		if(dp[indx] != -1) return dp[indx];
		
		int pick = nums.get(indx) + f(indx-2, nums, dp);
		int notpick = 0 + f(indx-1, nums, dp);
		dp[indx] = Integer.max(pick, notpick);
		return dp[indx];			
	}*/

	//tabulation with same tc and sc as memoization
	/*public static int f(int indx, ArrayList<Integer> nums, int[] dp) {
		dp[0] = nums.get(0);
		int n = nums.size();
        // Iterate through the input array to fill the dp array.
        for (int i = 1; i < nums.size(); i++) {
            // Calculate the maximum sum by either picking the current element or not picking it.
            int pick = nums.get(i);    
            // If there are at least two elements before the current element, add the value from dp[i-2].
            if (i > 1)
                pick += dp[i - 2];
         
            // The non-pick option is to use the maximum sum from the previous element.
            int nonPick = dp[i - 1];
            // Store the maximum of the two options in the dp array for the current index.
            dp[i] = Math.max(pick, nonPick);
        }
        // The final element of the dp array contains the maximum possible sum.
        return dp[n - 1];			
	}*/

	//space optimization with O(n) tc and O(1) sc
	public static int f(int n, ArrayList<Integer> nums) {
        // Initialize variables to keep track of the maximum sums at the current and previous positions.
        int prev = nums.get(0);
        int prev2 = 0;

        // Iterate through the array starting from the second element.
        for (int i = 1; i < n; i++) {
            // Calculate the maximum sum by either picking the current element or not picking it.
            int pick = nums.get(i);

            // If there are at least two elements before the current element, add the value from prev2.
            if (i > 1)
                pick += prev2;

            // The non-pick option is to use the maximum sum from the previous position.
            int nonPick = prev;

            // Calculate the maximum sum for the current position and update prev and prev2.
            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }

        // The 'prev' variable now holds the maximum possible sum.
        return prev;
    }


	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n = nums.size();
		/*int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		return f(n-1, nums, dp);*/
		return f(n, nums);
	}
}
