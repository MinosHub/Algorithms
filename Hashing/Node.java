package Hashing;

public class Node {

    public int data;
    public Node next;
    
    // these are members based on the design
    public int accountNum;
    public String accountName;
    public String other;

    public Node (int key) {
        data = key;
        next = null;
    }
}
