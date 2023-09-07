import java.util.* ;
import java.io.*; 
/*************************************************************

	Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static Node sortLL(Node head) {
		  if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the linked list
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        // Split the linked list into two halves
        middle.next = null;

        // Recursively sort the two halves
        Node left = sortLL(head);
        Node right = sortLL(nextOfMiddle);

        // Merge the two sorted halves
        return merge(left, right);
    }

    private static Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node merge(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }
}