//return true if the given singly LL is a palindrome otherwise return false

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

public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
         Node tempA = firstHead;
        Node tempB = secondHead;
        int lengthA = 0;
        while(tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        int lengthB = 0;
        while(tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
        tempA = firstHead;
        tempB = secondHead;
        if(lengthA>lengthB) {
            int steps = lengthA-lengthB;
            for(int i=1; i<=steps; i++) {
                tempA = tempA.next;
            }
        } else {
            int steps = lengthB-lengthA;
            for(int i=1; i<=steps; i++) {
                tempB = tempB.next;
            }
        }
        while(tempA!=tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA.data;
    }
}