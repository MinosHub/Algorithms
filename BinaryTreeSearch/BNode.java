package BinaryTreeSearch;

public class BNode {
    BNode left, right;
    int data;
    public BNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new BNode(value);
            }
            else {
                left.insert(value);
            }
        }
        else {
            if(right == null) {
                right = new BNode(value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;            
        }
        else if (value < data) {
            if (left == null) {
                return false;       
            }
            else {
                return left.contains(value);
            }
        }
        else {
            if (right == null) {
                return false;
            }
            else {
                return right.contains(value); 
            }
        }
    }

    public void printInOrder() { // LVR - AKA In-Order

        // L
        if (left != null) {
            left.printInOrder();
        }

        // V
        System.out.println(data);
        
        // R
        if(right != null) {
            right.printInOrder();
        }

    }

    public void printPreOrder() { // VLR - AKA Pre-Order
        
        // V
        System.out.println(data);

        
        // L
        if (left != null) {
            left.printPreOrder();
        }
        
        // R
        if(right != null) {
            right.printPreOrder();
        }
        
    }

    public void printPostOrder() { // LRV - AKA Post-Order

        // L
        if (left != null) {
            left.printPostOrder();
        }

        // R
        if(right != null) {
            right.printPostOrder();
        }

        // V
        System.out.println(data);
        
    }
}
