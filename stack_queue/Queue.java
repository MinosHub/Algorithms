package stack_queue;

public class Queue {
    Node head;

    public Queue() {
        head = null;
    }

    void enQueue(int key) {
        Node n = new Node(key);
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

    int deQueue() {
        if(head == null) {
            return -1000000;
        }
        Node curr = head;
        head = head.next;
        return curr.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    int peek() {
        if(head == null) {
            return -10000000;
        }
        return head.data;
    }

    public static void main(String[] args) {
        
        Queue q = new Queue();
        // q.enQueue(34);
        // q.enQueue(12);
        // q.enQueue(78);

        // System.out.println(q.peek() + " " + q.peek() + " " + q.peek());
        // System.out.println(q.deQueue() + " " + q.deQueue() + " " + q.deQueue());
    }
}
