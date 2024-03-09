import java.util.* ;
import java.io.*; 

public class Solution {

	public static String stringConcatenation(String num1, String num2) {
		// Write your code here.
		 StringBuilder reversedNum1 = new StringBuilder(num1).reverse();
        StringBuilder reversedNum2 = new StringBuilder(num2).reverse();

        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int i = 0;

        // Add digits until both strings are exhausted
        while (i < reversedNum1.length() || i < reversedNum2.length() || carry != 0) {
            int digit1 = (i < reversedNum1.length()) ? Character.getNumericValue(reversedNum1.charAt(i)) : 0;
            int digit2 = (i < reversedNum2.length()) ? Character.getNumericValue(reversedNum2.charAt(i)) : 0;

            int total = digit1 + digit2 + carry;
            int resultDigit = total % 10;
            carry = total / 10;

            sum.append(resultDigit);
            i++;
        }

        // Reverse the result back
        String result = sum.reverse().toString();
		return result;
	}

}
