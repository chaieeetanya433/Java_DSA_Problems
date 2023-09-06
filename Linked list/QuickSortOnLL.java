/*
    You are given a Singly LL of integers. 
    sort the LL using Quick sort algorithm.
 */

import java.util.* ;
import java.io.*; 
/**************************************************************

    Following is the class structure of the Node class:

	class LinkedListNode {
	    public int data;
	    public LinkedListNode next;

	    LinkedListNode(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}

***************************************************************/

public class Solution {
	 public static LinkedListNode quickSortLL(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: already sorted or single node list
        }

        // Step 1: Partition the list into smaller and larger parts
        LinkedListNode pivotNode = head;
        LinkedListNode smallerHead = new LinkedListNode(-1); // dummy head for smaller part
        LinkedListNode smallerTail = smallerHead;
        LinkedListNode largerHead = new LinkedListNode(-1); // dummy head for larger part
        LinkedListNode largerTail = largerHead;

        LinkedListNode current = head.next; // start from the second node

        while (current != null) {
            if (current.data < pivotNode.data) {
                smallerTail.next = current;
                smallerTail = smallerTail.next;
            } else {
                largerTail.next = current;
                largerTail = largerTail.next;
            }
            current = current.next;
        }

        smallerTail.next = null;
        largerTail.next = null;

        // Step 2: Recursively sort the smaller and larger parts
        LinkedListNode sortedSmallerPart = quickSortLL(smallerHead.next);
        LinkedListNode sortedLargerPart = quickSortLL(largerHead.next);

        // Step 3: Concatenate the sorted smaller, pivot, and larger parts
        LinkedListNode sortedListHead = sortedSmallerPart;

        if (sortedListHead == null) {
            sortedListHead = pivotNode;
        } else {
            LinkedListNode lastNodeOfSmaller = getTailNode(sortedSmallerPart);
            lastNodeOfSmaller.next = pivotNode;
        }

        pivotNode.next = sortedLargerPart;

        return sortedListHead;
    }

    private static LinkedListNode getTailNode(LinkedListNode head) {
        if (head == null) return null;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}

