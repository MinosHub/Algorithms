package stack_queue;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(34);
        q.enQueue(12);
        q.enQueue(78);

        System.out.println(q.peek() + " " + q.peek() + " " + q.peek());
        System.out.println(q.deQueue() + " " + q.deQueue() + " " + q.deQueue());

        Stack s = new Stack();
        s.push(45);
        s.push(12);
        s.push(98);
        s.push(9);
        s.push(78);

        System.out.println(s.peek() + " " + s.peek() + " " + s.peek());

        // System.out.println("poping top of the stack = " + s.pop());
        // System.out.println("item top of the stack = " + s.peek());

        
    }
}
