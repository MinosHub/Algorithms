package stack_queue;

public class Stack {
    Node top;

    public Stack() {
        top = null;
    }

    void push(int key) { // taking the value you would like to add
        Node n = new Node(key); // creating the first element of the data in object form
        n.next = top; //
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

    int peek() {
        if(top == null) {
            return -10000000;
        }
        return top.data;
    }
}