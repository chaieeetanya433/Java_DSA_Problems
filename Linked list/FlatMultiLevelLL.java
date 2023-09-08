//flatten the multilevel LL into a singly LL

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            // An empty list or a list with a single node is considered a palindrome
            return true;
        }
        
        // Find the middle of the linked list using slow and fast pointers
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the linked list
        slow.next = reverse(slow.next);
        
        // Compare the first half with the reversed second half
        LinkedListNode<Integer> firstHalf = head;
        LinkedListNode<Integer> secondHalf = slow.next;
        
        while (secondHalf != null) {
            if (!firstHalf.data.equals(secondHalf.data)) {
                return false; // Not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true; // The linked list is a palindrome
    }
    
    // Helper function to reverse a linked list
    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        while (current != null) {
            LinkedListNode<Integer> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}