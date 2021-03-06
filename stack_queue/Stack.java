package stack_queue;

public class Stack {
    Node top;

    public Stack() {
        top = null;
    }

    void push(int key) {
        Node n = new Node(key);
        n.next = top;
        top = n;
    }

    int pop(){
        if(top != null) {
            Node curr = top;
            top = top.next;
            return curr.data;
        }
        return -1000000;
    }
}