//need to perform insertion sort on singly LL

import java.util.* ;
import java.io.*; 
/****************************************************************
    Following is the Linked List node structure

    class Node
    {
    public:
        int data;
        Node *next;
        Node(int data)
        {
            this->data = data;
            this->next = NULL;
        }
    };

*****************************************************************/

public class Solution
{
public static Node insertionSortLL(Node head)
    {
        // Write your code here
        Node dummy = new Node(100);
        Node temp = head;
        while(temp!=null) {
            Node Next = temp.next;
            Node temp2 = dummy;
            while(temp2.next != null && temp2.next.data<temp.data) {
                temp2 = temp2.next;
            }
            temp.next=temp2.next;
            temp2.next=temp;
            temp=Next;
        }
        return dummy.next;
    }
}

