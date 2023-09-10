//Your task is to remove the duplicate nodes from the LL

import java.util.* ;
import java.io.*; 

/************************************************************

    Following is the linked list node structure
    
    class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

************************************************************/


public class Solution {
	
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {

        // Write your code here	
        HashSet<Integer> hs = new HashSet<>();
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        while(curr != null) {
            int val = curr.data;
            if(hs.contains(val)) {
                prev.next = curr.next;
            } else {
                hs.add(val);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
	}
}