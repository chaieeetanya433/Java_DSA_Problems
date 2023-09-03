import java.util.Scanner;

public class spiralPrint {

    public static void spiralPrint(int matrix[][]){
		//Your code goes here

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
		
        int row = matrix.length;
        int col = matrix[0].length;

        int count = 0;
        int total = row*col;

        //index initialization
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = row-1;
        int endingCol = col-1;
        

        while(count<total) {
            //printing starting now
            for(int index = startingCol; count<total && index<=endingCol; index++) {
                System.out.print(matrix[startingRow][index] + " ");
                count++;
            }
            startingRow++;

            //print ending col
            for(int index=startingRow; count<total && index<=endingRow; index++) {
                System.out.print(matrix[index][endingCol] + " ");
                 count++; 
            }
            endingCol--;
            
            //printing ending row
            for(int index = endingCol; count<total && index>=startingCol; index--) {
                System.out.print(matrix[endingRow][index] + " ");
                 count++;
            }
            endingRow--;

            //printing starting col
            for(int index=endingRow; count<total && index>=startingRow; index--) {
                System.out.print(matrix[index][startingCol] + " ");
                 count++;
            }
            startingCol++;
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

        spiralPrint(arr);
    }
}
 