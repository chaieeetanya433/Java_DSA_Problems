import java.util.*;

public class Solution {
    public static List<List<Integer>> fourSum(int []nums, int target) {
        // Write your code here.
        /*
        BRUTE FORCE APP:-
            TC:- O(N^4) SC:-O(no. of quads) * 2
        */
        Set<List<Integer>> st = new HashSet<>();
        // check all possible triplets:
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for(int l = k+1; l<n; l++) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        temp.sort(null);
                        st.add(temp);
                    }
                    }
                }
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

        /*
        OPTIMAL SOLUTION:

        */
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }
} 