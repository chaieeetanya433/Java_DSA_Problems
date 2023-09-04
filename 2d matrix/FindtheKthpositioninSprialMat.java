import java.util.* ;
import java.io.*; 
public class Solution {

	public static int findKthElement(int[][] matrix, int k) {
	    // Write your code here.
       int row = matrix.length;
        int col = matrix[0].length;

        int count = 0;
        int total = row * col;

        // Index initialization
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = row - 1;
        int endingCol = col - 1;

        while (count < total) {
            // Printing starting column
            for (int index = startingCol; count < total && index <= endingCol; index++) {
                count++;
                if (count == k) {
                    return matrix[startingRow][index];
                }
            }
            startingRow++;

            // Print ending row
            for (int index = startingRow; count < total && index <= endingRow; index++) {
                count++;
                if (count == k) {
                    return matrix[index][endingCol];
                }
            }
            endingCol--;

            // Printing ending column
            for (int index = endingCol; count < total && index >= startingCol; index--) {
                count++;
                if (count == k) {
                    return matrix[endingRow][index];
                }
            }
            endingRow--;

            // Printing starting row
            for (int index = endingRow; count < total && index >= startingRow; index--) {
                count++;
                if (count == k) {
                    return matrix[index][startingCol];
                }
            }
            startingCol++;
        }

        // Return -1 if k is out of bounds
        return -1;
	}
}
