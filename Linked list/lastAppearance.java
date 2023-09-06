//you are given an unsorted singly LL with 'N' nodes which may contain duplicate elements. you are supposed to remove all duplicate elements from the LL ans keep only the last appearance of elements.
import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class Node {
	    int data;
	    Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/

public class Solution {
	public static Node lastAppearance(Node head) {
		// Write your code here
         if(head == null || head.next == null)return head;
       
       HashMap<Integer, Integer> hm = new HashMap<>();
       
       Node temp = head;
       
       while(temp != null){
           hm.put((int)temp.data, hm.getOrDefault((int)temp.data,0) +1);
           temp = temp.next;
       }
       
       temp = head;
       Node nhead = null;
       Node copy = nhead;
       
       while(temp != null){
           if(hm.get((int)temp.data) > 1){
               hm.put(temp.data, hm.get((int)temp.data)-1);
           }else{
               if(nhead == null){
                   nhead = temp;
                   copy = nhead;
               }else{
                   copy.next = temp;
                   copy = copy.next;
               }
           }
           temp = temp.next;
       }
       copy.next = null;
       return nhead;
	}
}