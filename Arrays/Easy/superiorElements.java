import java.util.*;

public class superiorElements {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        int n = a.length;
        for(int i=n-1; i>=0; i--) {
            if(a[i] > maxi) {
                ans.add(a[i]);
            }
            maxi = Math.max(maxi, a[i]);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {12, 22, 3, 4, 1,  0};
        List<Integer> ls = superiorElements(arr);
        System.out.println(ls);
    }
}
