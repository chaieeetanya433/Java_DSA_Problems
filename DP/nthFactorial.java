import java.util.*;

public class factorialNo {

    // normal recursive approach tc=O(n) sc=O(n)
    /*
     * public static int facto(int n) {
     * if(n == 0) return 1;
     * 
     * return facto(n-1)*n;
     * }
     */

    // memoization tc=O(n) sc=O(n)
    /*
     * public static int facto(int n, int[] memo) {
     * if(n == 0) return 1;
     * 
     * if(memo[n] != -1) {
     * return memo[n];
     * }
     * 
     * memo[n] = facto(n-1, memo)*n;
     * 
     * return memo[n];
     * }
     */

    public static int facto(int n, int[] memo) {
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = facto(n - 1, memo) * n;
        }

        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int memo[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        System.out.println("Factorial of " + n + " is " + facto(n, memo));
    }
}
