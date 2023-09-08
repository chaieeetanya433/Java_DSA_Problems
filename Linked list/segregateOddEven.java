

/*************************************************************

	Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static Node segregateOddEven(Node head) {
		// Write your code here.
		if(head == null) {
			return null;
		}
		Node temp = head;
		Node Ohead = new Node(-1);
		Node Ehead = new Node(-1);
		Node tempO = Ohead;
		Node tempE = Ehead;
		while(temp!=null) {
			if(temp.data%2==0) {
				tempE.next = temp;
				tempE = tempE.next;
			} else {
				tempO.next = temp;
				tempO = tempO.next;
			}
			temp = temp.next;
		} 
		Ohead = Ohead.next;
		Ehead = Ehead.next;
		if(Ohead==null) {
			tempE.next = null;
			return Ehead;
		}
		tempO.next = Ehead;
		tempE.next = null;
		return Ohead;
	}
}