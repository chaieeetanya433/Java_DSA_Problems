//Given a LL of 'N' integers, remove Kth node from the end of the LL

import java.util.*;
import java.io.*;

public class Solution {
    public static boolean isPossible(int[] stalls, int dist, int cows) {
        int cowCnt = 1;
        int lastPos = stalls[0];

        for(int i=0; i<stalls.length; i++) {
            if(stalls[i]-lastPos >= dist) {
                cowCnt++;
                lastPos = stalls[i];
            }
            if(cowCnt >= cows) return true;
        }
        return false;
    }

    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1, high = stalls[n-1]-stalls[0];
        while(low<=high) {
            int mid = (low+high)/2;
            if(isPossible(stalls, mid, k) == true) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }
} 