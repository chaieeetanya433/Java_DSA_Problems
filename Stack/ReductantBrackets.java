import java.util.* ;
import java.io.*; 
/*
Problem statement
Given valid mathematical expressions in the form of a string. You are supposed to return true if the given expression contains a pair of redundant brackets, else return false. The given string only contains ‘(‘, ’)’, ‘+’, ‘-’, ‘*’, ‘/’ and lowercase English letters.

Note :
A pair of brackets is said to be redundant when a subexpression is surrounded by needless/ useless brackets.

For Example :
((a+b)) has a pair of redundant brackets. The pair of brackets on the first and last index is needless. 
While (a + (b*c)) does not have any pair of redundant brackets. 

*/

import java.util.ArrayList;

public class Solution 
{
     public static boolean findRedundantBrackets(String s) 
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                boolean foundOperators = false;
                while(!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if(top == '+' || top == '-' || top == '*' || top == '/') {
                        foundOperators = true;
                    }
                }
                stack.pop(); // pop the '('
                if(!foundOperators) {
                    return true; // redundant brackets found
                }
            } else {
                stack.push(ch);
            }
        }
        return false; // no redundant brackets found
    }
}
