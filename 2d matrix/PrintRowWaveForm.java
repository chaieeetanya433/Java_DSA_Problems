import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    /*
     input:
     2 3 4
     5 6 7
     8 9 10

     output:
     2 3 4 7 6 5 8 9 10
     */

	public static ArrayList<Integer> rowWaveForm(ArrayList<ArrayList<Integer>> mat) {

		// Write your code here
		int nrows = mat.size();
		int mCols = mat.get(0).size();
	
		ArrayList<Integer> ans = new ArrayList<>(nrows*mCols);
		int index = 0;

		for(int row=0; row<nrows; row++) {
			if((row & 1) == 1) {
				//odd case -> right to left
				for(int col=mCols-1; col>=0; col--) {
					ans.add(index++, mat.get(row).get(col));
				}
			} else {
				//even case -> left to right
				for(int col=0; col<mCols; col++) {
					ans.add(index++, mat.get(row).get(col));
				}
			}
		}
		return ans;
	}
}
