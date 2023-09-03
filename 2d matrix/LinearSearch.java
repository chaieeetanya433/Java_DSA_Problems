import java.util.*;

public class LinearSearch {

    public static boolean isSearch(int[][] arr, int target, int row, int col) {
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(arr[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[][] arr = { { 1, 2 }, { 3, 4 }, {5, 6} };   //3x2 matrix
        
        //printing row wise
        /*for (int i = 0; i < 3; i++)
            for (int j = 0; j < 2; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                                + arr[i][j]);
        //printing column wise
        for (int j = 0; j < 2; j++)
            for (int i = 0; i < 3; i++)
                System.out.println("arr[" + i + "][" + j + "] = "
                                + arr[i][j]);*/

                Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][2];

        //taking input row wise
        for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int target;
        System.out.println("enter the target you are looking for : ");
        target = sc.nextInt();

        if(isSearch(arr, target, 3, 2) == true) {
            System.out.println("Element found");
        } 
        else {
            System.out.println("Element not found");
        }

    }
}