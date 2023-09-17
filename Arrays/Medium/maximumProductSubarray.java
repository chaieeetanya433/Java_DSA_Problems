import java.util.*;

public class maximumProductSubarray {
    public static int maxSubArr(int[] arr, int n) {
        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int maxProduct = arr[0];

        for (int i = 1; i < n; i++) {
            // If the current element is negative, swap maxEndingHere and minEndingHere
            if (arr[i] < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            // Update the maximum and minimum ending here
            maxEndingHere = Math.max(arr[i], maxEndingHere * arr[i]);
            minEndingHere = Math.min(arr[i], minEndingHere * arr[i]);

            // Update the maximum product
            maxProduct = Math.max(maxProduct, maxEndingHere);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = -2;
        arr[2] = 4;
        arr[3] = 68;
        arr[4] = 33;

        int ans;
        ans = maxSubArr(arr, n);
        System.out.println("The maximum product subarray's product is: " + ans);
    }
}
