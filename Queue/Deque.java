/*
Problem statement
Design a data structure to implement deque of size ‘N’. It should support the following operations:

pushFront(X): Inserts an element X in the front of the deque. Returns true if the element is inserted, otherwise false.

pushRear(X): Inserts an element X in the back of the deque. Returns true if the element is inserted, otherwise false.

popFront(): Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.

popRear(): Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.

getFront(): Returns the first element of the deque. If the deque is empty, it returns -1.

getRear(): Returns the last element of the deque. If the deque is empty, it returns -1.

isEmpty(): Returns true if the deque is empty, otherwise false.

isFull(): Returns true if the deque is full, otherwise false.
Following types of queries denote these operations:

Type 1: for pushFront(X) operation.
Type 2: for pushRear(X) operation.
Type 3: for popFront() operation.
Type 4: for popRear() operation.
Type 5: for getFront() operation.
Type 6: for getRear() operation.
Type 7: for isEmpty() operation.
Type 8: for isFull() operation.
*/

import java.util.* ;
import java.io.*; 

public class Deque {
    // Initialize your data structure.
    int arr[];
    int front;
    int rear;
    int size;
 
    public Deque(int n) {
    // Write your code here.
    arr = new int[n]; // Update to use the size provided in the constructor
    front = -1;
    rear = 0;
    this.size = n;
}

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x) {
        // Write your code here.
        if(isFull()) {
            return false;
        }

        if(front == -1) {
            front = 0;
            rear = 0;
        }

        else if(front == 0) 
            front = size - 1;
        else 
            front = front - 1;

        arr[front] = x;
        return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x) {
        // Write your code here.
        if(isFull()) {
            return false;
        }

        if(front == -1) {
            front = 0;
            rear = 0;
        }

        else if(rear == size-1) 
            rear = 0;
        else 
            rear = rear + 1;
        
        arr[rear] = x;
        return true;
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popFront() {
        // Write your code here.
        if(isEmpty()) {
            return -1;
        }

        int popped = arr[front];

        if(front == rear) {
            front = -1;
            rear = -1;
        } else 
            if(front == size-1) 
                front = 0;
        else 
            front = front + 1;

        return popped;
    }


    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popRear() {
        // Write your code here.
        if(isEmpty()) {
            return -1;
        }

        int popped = arr[rear];

        if(front == rear) {
            front = -1;
            rear = -1;
        }
        else if(rear == 0)
            rear = size-1;
        else 
            rear = rear - 1;

        return popped;
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront() {
        // Write your code here.
        if(isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear() {
        // Write your code here.
        if(isEmpty() || rear < 0) {
            return -1;
        } 
        return arr[rear];
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() {
        // Write your code here.
        return front == -1;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() {
        // Write your code here.
        return (front == 0 && rear == size-1) || (front == rear+1);
    }
}
