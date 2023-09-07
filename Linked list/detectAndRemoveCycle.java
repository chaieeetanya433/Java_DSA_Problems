//Given a singly LL, determine if it forms a cycle or not. if there is a cycle and return the list.

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        	int data;
	        Node next;
	        Node(int data)
	        {
		        this.data = data;
		        this.next = null;
	        }
	        
        }
        
*****************************************************************/

public class Solution 
{
	public static boolean detectAndRemoveCycle(Node head) 
	{
		// Write your code here.
		if(head == null || head.next == null) {
             return false;
         }
		  Node slow = head;
         Node fast = head;

        while(fast!=null) {
			if(slow == null) return false;
            slow = slow.next;
			if(fast.next == null) return false;
            fast = fast.next.next;
            if(fast == slow) {
				fast.next = null;
				return true;
			}
        }
		return false;
	}
}
