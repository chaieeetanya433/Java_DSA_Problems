//Sort the given LL consisting of 0s, 1s and 2s.

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
    public static Node sortList(Node head) {
        // Write your code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        Node temp = head;
        while(temp!=null) {
            if(temp.data == 0) {
                count0++;
            } else if(temp.data == 1) {
                count1++;
            } else if(temp.data == 2){
                count2++;
            }
            temp = temp.next;
        }
        
        temp = head;
        while(temp!=null) {
            if(count0 != 0) {
                temp.data = 0;
                count0--;
            } else if(count1 != 0) {
                temp.data = 1;
                count1--;
            } else if(count2 != 0) {
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }
}