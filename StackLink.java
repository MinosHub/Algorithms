class Node {
    public int data;
    public Node next;

    public Node(int key) {
        data = key;
        next = null;
    }
}

public class StackLink {

    private int[] Data;
    private int top;
    private int maxSize;

    public StackLink(int size) {
        maxSize = size;
        Data = new int[maxSize];
        top = -1;
    }

    boolean push(int key) {
        if(top == maxSize){
            return false;
        }
        top++;
        Data[top] = key;
        return true;
    }

    int pop() {
        if(top != 1) {
            top--;
            return Data[top+1];
        }
        return -1000000;
    }

    boolean isEmpty() {
        return top == -1;
    }

    int peek() {
        if(top == -1) {
            return -1000000;
        }
        return Data[top];
    }
    
    public static void main(String[] args) {
        // Stack stack = new Stack();
        // stack.push(45);
        // stack.push(12);
        // stack.push(98);
        
        System.out.println("start");
    }
 }