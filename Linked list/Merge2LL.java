//return the singly sorted LL after combination of two sorted LL

import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// Write your code here.
        LinkedListNode<Integer> temp1 = first;
        LinkedListNode<Integer> temp2 = second;
        LinkedListNode<Integer> head = new LinkedListNode(100);
        LinkedListNode<Integer> temp = head;
        while(temp1!=null && temp2!=null) {
            if(temp1.data < temp2.data) {
                LinkedListNode<Integer> node = new LinkedListNode(temp1.data);
                temp.next = node;
                temp = node;
                temp1 = temp1.next;
            } else {
                LinkedListNode<Integer> node = new LinkedListNode(temp2.data);
                temp.next = node;
                temp = node;
                temp2 = temp2.next;
            }
        }
        if(temp1 == null) {
            temp.next = temp2;
        } else {
            temp.next = temp1;
        }
        return head.next;
    
	}
}
