package stack_queue;

public class Queue {
    Node head;

    public Queue() {
        head = null;
    }

    void enQueue(int key) {
        Node n = new Node(key);  // new item enters the queue in the last spot
        if(head == null) {
            head = n;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
    }

    int deQueue() { // if queue exists then deQueue first item
        if(head == null) {
            return -1000000;
        }
        Node curr = head;
        head = head.next;
        return curr.data; // return the next item to be deQueued
    }

    boolean isEmpty() {
        return head == null; // this will return boolean
    }

    int peek() {
        if(head == null) {
            return -10000000;
        }
        return head.data;  // will return the data if it exists
    }   
}