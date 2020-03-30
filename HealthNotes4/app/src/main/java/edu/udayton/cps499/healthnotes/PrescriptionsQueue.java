package edu.udayton.cps499.healthnotes;

import org.w3c.dom.Node;

class QueueNode {
    QueueNode next;
    Comparable value;

    public QueueNode(Comparable key){
        value = key;
        next = null;
    }
}//end QueueNode class

class Queue {
    QueueNode head, tail;

    public Queue() {
        head = tail = null;
    }

    //enqueue
    public void enqueue (Comparable key) {
        QueueNode temp = new QueueNode(key);

        // If queue is empty, then new node is front and rear both 
        if (tail == null) {
            this.head = this.tail = temp;
            return;
        }

        // Add the new node at the end of queue and change rear 
        tail.next = temp;
        tail = temp;
    }//end enqueue

    // Method to remove an key from queue.
    public Comparable dequeue() {
        // If queue is empty, return NULL.
        if (head == null) {
            return null;
        }

        // Store value of head into temp then advance head to the next item
        QueueNode temp = head;
        head = head.next;

        // If head becomes NULL, then change tail also as NULL
        if (head == null) {
            tail = null;
        }

        return temp.value;
    }//end dequeue


    public Comparable peek() {
        //if head is null return null
        if (head == null) return null;

        return head.value;
    }//end peek


}//end Queue class


