import java.util.*;

public class Solution {
     public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= n - m; i++) {
            String currentSubstring = str.substring(i, i + m);

            if (areAnagrams(currentSubstring, ptr)) {
                result.add(i);
            }
        }

        return result;
    }

    // Helper function to check if two strings are anagrams
    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}