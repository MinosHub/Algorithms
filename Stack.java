public class Stack {  // LIFO   || Last In | First Out

    private int[] stackData;
    private int top;
    private int maxSize;

    public Stack(int size) {
        maxSize = size;
        stackData = new int[maxSize];
        top = -1;
    }

    boolean push(int key) { 
        if(top == maxSize){
            return false;
        }
        top++;
        stackData[top] = key;
        return true;
    }

    int pop() { 
        if(top != 1) {
            top--;
            return stackData[top+1];
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
        return stackData[top];
    }
    
    public static void main(String[] args) {

        Stack s = new Stack(10);
        s.push(45);
        s.push(12);
        s.push(12);
        
        if(s.isEmpty()) {
            System.out.println("The Link List is Empty");
        }
        else {
            System.out.println(s.peek());
        }

        
    }
 }