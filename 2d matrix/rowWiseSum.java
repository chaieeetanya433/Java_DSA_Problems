import java.util.Scanner;

public class rowWiseSum {

    public static void printSum(int[][] arr, int row, int col) {
        System.out.println("Printing sum -> ");
        for(int i=0; i<row; i++) {
            int sum = 0;
            for(int j=0; j<col; j++) {
                sum += arr[i][j];
            }
            System.out.print(sum+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];

        //taking input row wise
        System.out.println("Enter the elements : ");
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        printSum(arr, 3, 3);
    }
}
