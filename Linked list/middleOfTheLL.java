//return the middle node of the LL

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
 }

 *****************************************************************/

public class Solution
{
    public static Node findMiddle(Node head)
    {
        // Write your code here.

        Node temp = head;
        int cnt = 0;
        while(temp != null) {
            cnt++;
            temp = temp.next;
        }
        temp = head;

        for(int i=0; i<cnt/2; i++) {
            temp = temp.next;
        }

        return temp;
       
    }
}