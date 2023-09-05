import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int lowerBound(List<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) >= x) {
                ans = mid;
                // look for more small index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look for right
            }
        }
        return ans;
    }

	public static int maxOne(ArrayList<ArrayList<Integer>> arr) {

		// Write your code here
		//brute force with tc:- O(m*n)
		// int index = -1;
		// int maxCnt = -1;
		// int nrows = arr.size();
		// int mcols = arr.get(0).size();
		// int cntRow;
		// for(int i=0; i<nrows; i++) {
		// 	cntRow = 0;
		// 	for(int j=0; j<mcols; j++) {
		// 		cntRow += arr.get(i).get(j);
		// 	}
		// 	if(cntRow > maxCnt) {
		// 		maxCnt = cntRow;
		// 		index = i;
		// 	}
		// } 
		// return index;

		//optimal approach
		/*
		Time Complexity: O(n X logm), where n = given row number, m = given column number.
Reason: We are using a loop running for n times to traverse the rows. Then we are applying binary search on each row with m columns.

Space Complexity: O(1) as we are not using any extra space.
		*/
		int n = arr.size();
		int m = arr.get(0).size();
		int cntMax = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int cnt_ones = m - lowerBound(arr.get(i), m, 1);
            if (cnt_ones > cntMax) {
                cntMax = cnt_ones;
                index = i;
            }
        }
        return index;

		
	}
}