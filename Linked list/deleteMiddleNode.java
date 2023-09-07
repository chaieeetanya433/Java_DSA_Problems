//Given a singly LL of 'N' nodes. Your task is to delete the middle node of the list and return head of the modified list.

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

public class Solution {
    public static Node deleteMiddle(Node head) {
        // Write your code here.
        if(head.next==null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}