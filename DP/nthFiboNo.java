import java.util.*;


public class Solution {

	//top down approach - recursion + memoization
	public static int fibo(int n, int[] dp) {
		if(n==1 || n==0) {
			return n;
		}

		if(dp[n] != -1) {
			return dp[n];
		}

		dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
		return dp[n];
	}
	//bottom-up approach - recursion + tabulation
	/*public static int fibo(int n, int[] dp) {
		if(n==1 || n==0) {
			return n;
		}

		dp[1] = 1;
		dp[0] = 0;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[n-2];
		}
		return dp[n];
	}*/

	//space optimized tc=O(1) 
	/*public static int fib(int n) {
		int prev1=1;
		int prev2=0;

		if(n==0) {
			return prev2;
		}

		for(int i=2; i<=n; i++) {
			int curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}*/
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];

		for(int i=0; i<=n; i++) {
			dp[i] = -1;
		}

		System.out.print(fibo(n, dp));
		
	}

}
