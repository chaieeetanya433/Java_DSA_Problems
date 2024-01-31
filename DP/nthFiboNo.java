import java.util.*;


public class Solution {

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
