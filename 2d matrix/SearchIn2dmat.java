import java.util.ArrayList;

public class SearchIn2dmat {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        int n=mat.size(),m=mat.get(0).size();
         int low=0,high=n*m-1,mid,row,col;
         while(low<=high)
         {
             mid=(low+high)/2;
             row=mid/m; // getting the row number
             col=mid%m; // getting the column number
             if(mat.get(row).get(col)==target) return true;
             else if(mat.get(row).get(col)>target) high=mid-1;
             else low= mid+1;

         }
         return false;
    }
}
