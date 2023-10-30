import java.util.*;


//link for the problem :- https://www.codingninjas.com/studio/problems/string-pair_4530131
//came in tcsCodevita

public class Solution {
    public static String convertIntToString(int n) {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    if (n >= 0 && n <= 9) {
        return digits[n];
    }
    return "";
    }

    public static int countVowels(String str) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
        }
        return cnt;
    }

    public static String stringPair(int n, int[] num) {
        String[] texts = new String[n];
    int sum = 0;

    for (int i = 0; i < n; i++) {
        texts[i] = convertIntToString(num[i]);
        sum += countVowels(texts[i]);
    }

    Arrays.sort(num);

    int pairCount = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (num[i] + num[j] == sum) {
                pairCount++;
            }
        }
    }

    if (pairCount > 100) {
        return "greater 100";
    } else {
        return convertIntToString(pairCount);
    }
    }
}