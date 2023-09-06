//you have been given 2 singly LL, where each of them represents a +ve no. without any leading zeros. Your task is to add these 2 no.'s and print the summation in the form of a LL

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class ListNode<T> {
 
		public T data;
		public ListNode<T> next;

		public ListNode(T data) {
			this.data = data;
		}
	}

************************************************************/

public class Solution {
	public static ListNode<Integer> addTwoLists(ListNode<Integer> first, ListNode<Integer> second) {
        // Reverse the linked lists to simplify the addition process
        first = reverseLinkedList(first);
        second = reverseLinkedList(second);

        ListNode<Integer> result = null;
        ListNode<Integer> current = null;
        int carry = 0;

        while (first != null || second != null || carry > 0) {
            int sum = carry;

            if (first != null) {
                sum += first.data;
                first = first.next;
            }

            if (second != null) {
                sum += second.data;
                second = second.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            ListNode<Integer> newNode = new ListNode<>(sum);
            if (result == null) {
                result = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }

        // Reverse the result linked list to get the correct order
        result = reverseLinkedList(result);

        return result;
    }

    // Helper method to reverse a linked list
    private static ListNode<Integer> reverseLinkedList(ListNode<Integer> head) {
        ListNode<Integer> prev = null;
        ListNode<Integer> current = head;

        while (current != null) {
            ListNode<Integer> nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
