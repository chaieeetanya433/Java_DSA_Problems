import java.util.*;

/*
 You are given an array consisting of N integers, and an integer, K. Your task is to determine the total sum of the minimum element and the maximum element of all subarrays of size K.

 sample i/p: 
1
5 3
1 2 3 4 5

 sample o/p:
18

 explanation of sample i/p:
 For the subarray starting from the 0th index and ending at the 2nd index, its minimum element is 1 and the maximum element is 3. Similarly, for the next subarray starting at the 1st index and ending at the 3rd index, the minimum value is 2 and the maximum is 4. And, for the last subarray, the minimum value is 3 and the maximum is 5. So, the total sum will be 1 + 3 + 2 + 4 + 3 + 5 = 18.
 */

public class sumOfMinAndMax {
    public static long sumOfMaxAndMin(ArrayList<Integer> nums, int n, int k) {
        // Write your code here.
        long totalSum = 0;

        // The TreeSet which will store the elements of the current window.
        TreeSet<Integer> st = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            st.add(nums.get(i));
        }

        int minCurrent = st.first();
        int maxCurrent = st.last();

        totalSum += minCurrent + maxCurrent;

        // Store the starting index of the previous window.
        int startIdx = 0;

        for (int i = k; i < n; i++) {
            st.remove(nums.get(startIdx));
            st.add(nums.get(i));

            // Minimum value in the TreeSet.
            minCurrent = st.first();

            // Maximum value in the TreeSet.
            maxCurrent = st.last();

            // For each window, add the maximum and minimum value to the final result.
            totalSum += minCurrent + maxCurrent;

            startIdx++;
        }

        return totalSum;
    }
}
