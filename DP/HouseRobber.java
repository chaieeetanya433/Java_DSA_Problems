import java.util.*;

public class Solution {

    public static long f(long[] nums) {
        int n = nums.length;
        long prev = nums[0];
        long prev2 = 0;

        for (int i = 1; i < n; i++) {
            long pick = nums[i];

            if (i > 1)
                pick += prev2;

            long nonPick = prev;

            long cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }

        return prev;
    }

    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if (n == 1) return valueInHouse[0];
        long[] temp1 = new long[n];
        long[] temp2 = new long[n];

        for (int i = 0; i < n; i++) {
            if (i != 0) temp1[i] = valueInHouse[i];
            if (i != n - 1) temp2[i] = valueInHouse[i];
        }

        return Math.max(f(temp1), f(temp2));

    }
}
