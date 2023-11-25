/*
 Ninja has three integers 'N', 'X', and 'Y'. Ninja wants to create an array 'A' of length 'N' such that it satisfies the following conditions:
• 'A[1] | A[2] | ... | A[N]' = X (where | denotes the bitwise OR operator).

 • 'A[1] & A[2] & … & A[N]' = Y (where & denotes the bitwise AND operator).

 • Every number of the array 'A' is unique.
Your task is to tell Ninja whether it is possible to create such an array or not. If it is possible, then return '1'. Otherwise, return '0'.
example:
Sample Input 1:
2
2 7 5
4 12 6
Sample Output 1:
1
0
Explanation Of Sample Input 1:
For test case 1:
One of the possible array 'A' is:
'A = [5, 7]'
So, the answer is '1'.

For test case 2:
Ninja can not make any array 'A' with all distinct elements which satisfy the conditions for 'X and 'Y'.
So, the answer is '0'.
Sample Input 2:
2
5 15 8
5 15 16
Sample Output 2:
1
0
 */

 import java.util.HashSet;

public class Solution {

    static int isPossible(int n, int x, int y) {
        // Check if it is possible to create an array
        if ((x & y) != y) {
            return 0;
        }

        // Create a set to check for uniqueness
        HashSet<Integer> set = new HashSet<>();

        // Fill the array
        for (int i = 0; i < n; i++) {
            int value = (1 << i);
            if ((value & x) != 0) {
                // If the corresponding bit is set in x, add it to the array
                set.add(value);
            }
        }

        // Check if the size of the set is equal to n (ensuring uniqueness)
        if (set.size() != n) {
            return 0;
        }

        return 1;
    }

}


