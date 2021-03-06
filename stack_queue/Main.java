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

        System.out.println(s.pop() + " " + s.pop() + " " + s.pop());
    }
}
