import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<Integer> searchInSortedArray(int[] arr, int n, int[] queries, int q) {
        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            ls.add(binarySearch(arr, 0, n - 1, queries[i]) ? 1 : 0);
        }

        return ls;
    }

    private static boolean binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
