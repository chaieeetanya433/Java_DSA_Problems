import java.util.*;

public class printLikeWaveProblem {

    /*
     * input:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 
     * output:
     * 1 4 7 2 5 8 3 6 9
     */

    /*
     * Observation:-
     * col index -> odd
     * then, go botton to top
     * col index -> even
     * then, go top to bottom
     * using for loop
     */

    public static void wavePrint(int arr[][], int nRows, int mCols) {
        // Write your code here.

        for (int col = 0; col < mCols; col++) {
            if (col % 2 == 0) {
                // even case -> go top to bottom
                for(int row=0; row<nRows; row++) {
                    System.out.print(arr[row][col] + " ");
                }
            } else {
                // odd case -> go bottom to top
                for (int row = nRows - 1; row >= 0; row--) {
                    System.out.print(arr[row][col] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];

        // taking input row wise
        System.out.println("Enter the elements : ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        wavePrint(arr, 3, 3);

    }
}
