//Your task is to delete the given node from the LL

import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/

public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
		// Write your code here.
         if (node == null || node.next == null) {
        // You can't delete the last node or a null node.
        return;
    }

    LinkedListNode<Integer> nextNode = node.next;
    node.data = nextNode.data;
    node.next = nextNode.next;
	}

}
