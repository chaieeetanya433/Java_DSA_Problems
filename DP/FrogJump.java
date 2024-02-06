import java.util.* ;
import java.io.*; 
public class FrogJump {

    //memoization approach with O(n) tc and sc
    /*public static int solve(int ind,int[] height,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne= solve(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
        if(ind>1)
            jumpTwo = solve(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);
    
        return dp[ind]=Math.min(jumpOne, jumpTwo);
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,heights,dp);
    }*/

    //tabulation approach with O(n) as sc and tc
    /*public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=1; i<n; i++) {
            int fs = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) ss = dp[i-2]+Math.abs(heights[i]-heights[i-2]);

            dp[i] = Math.min(fs, ss);
        }
        return dp[n-1];
    }*/

    //space optimized approach with O(1) sc and O(n) tc
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int prev1=0, prev2=0;
        for(int i=1; i<n; i++) {
            int fs = prev1 + Math.abs(heights[i]-heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) ss = prev2+Math.abs(heights[i]-heights[i-2]);

            int curi = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curi;
        }
        return prev1;
    }


}
