/*
Problem statement
You have given two positive integers N and K. Your task is to print a series of numbers i.e subtract K from N until it becomes 0 or negative then add K until it becomes N. You need to do this task without using any loop.

For Example:
For  N = 5 , K = 2 
Series = [ 5, 3, 1, -1, 1, 3, 5]

*/
import java.util.*;

public class Solution {

   static int size;

    static void add(int n, int k, List<Integer> ans) {
        if (n == size) return;
        ans.add(n + k);
        add(n + k, k, ans);
    }

    static void subtract(int n, int k, List<Integer> ans) {
        if (n <= 0) return;
        ans.add(n - k);
        subtract(n - k, k, ans);
    }

    public static List<Integer> printSeries(int n, int k) {
        size = n;
        List<Integer> ans = new ArrayList<>();
        ans.add(n);
        subtract(n, k, ans);
        add(ans.get(ans.size() - 1), k, ans);
        return ans;
    }
}
