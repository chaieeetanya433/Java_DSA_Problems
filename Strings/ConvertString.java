//ps
/*

You are given a string 'STR'. You have to convert the first alphabet of each word in a string to UPPER CASE.

For example:

If the given string 'STR' = ”I am a student of the third year” so you have to transform this string to ”I Am A Student Of The Third Year"
Note:

'STR' will contains only space and alphabets both uppercase and lowercase. The words will be separated by space.
*/


import java.util.* ;
import java.io.*; 
public class Solution{
	public static String convertString(String str) {
            // Write your code here
            char arr[] = str.toCharArray();
            StringBuilder modifiedString = new StringBuilder();
            boolean nextCapital = true;
            for(int i=0; i<arr.length; i++) {
                if(arr[i] == ' ' || nextCapital) {
                    modifiedString.append(Character.toUpperCase(arr[i]));
                    nextCapital = false;
                } else {
                    modifiedString.append(arr[i]);
                } 
                if(arr[i] == ' ') {
                    nextCapital = true;
                }
            }    
            str = modifiedString.toString();
            return str;
        }

}
