/*
 prob statement: Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order. 

 example:
    Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
Output: 4
Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements

Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.
 */


import java.io.*;
import java.util.* ;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<N; i++) {
            st.add(arr[i]);
        }

        int maxStreak = 0;
        for(int num : st) {
            if(!st.contains(num-1)) {    //num is starting point of a sequence
                int currNum = num; 
                int currStreak = 1; //length of current consecutive sequence
                while(st.contains(currNum+1)) { 
                    currStreak++;
                    currNum++;
                }
                maxStreak = Math.max(maxStreak, currStreak); 
            }
        }

        return maxStreak;
}
}