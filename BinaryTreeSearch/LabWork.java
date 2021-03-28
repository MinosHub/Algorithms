public class BNode {
    public int data;
    public BNode left;
    public BNode right;
    
    public BNode (int data){
        this.data=data;
        left=right=null;
    }  
}


public class BinaryTree {
    private BNode root;
    
    
    public BinaryTree(){
        root=null;
    }
    
    /* Standard non recursive insert: The code is basically the same as inserting a t the end of a linked list.
       The only diference is that we have to decide left or right at each node.
    */
    public void insert(int item){
        BNode newNode= new BNode(item);
        BNode parent,curr;
        if (root==null){
            root= newNode;
            return;
        }
        parent =curr= root;
        while (curr!=null){
            parent=curr;
            if (curr.data==item){
                return;
            }
            if (item <curr.data)
                curr=curr.left;
            else
                curr=curr.right;          
        }
        if (item <parent.data)
                parent.left=newNode;
            else
                parent.right=newNode;     
        
    }

    // recursive insert
    public void recInsert(int item){
       root = recInsertHelper(root,item) ;
    }
    
    private BNode recInsertHelper(BNode curr, int item){
        if (curr ==null){
            BNode newNode= new BNode(item);
            return newNode;
        }
        if (item<curr.data){
            curr.left=recInsertHelper(curr.left,item);
        }
        if (item>curr.data){
            curr.right=recInsertHelper(curr.right,item);
        }
        return curr;
    }
    
   
    // Traversals : pre ,in ,post, level
    public void preOrder(){
        System.out.print("Pre Order: ");
        preOrderHelper(root);
        System.out.println("");
    }
    
    private void preOrderHelper(BNode curr){ ///  vist, go left, go right
        if (curr==null) return;
        System.out.print( curr.data+" ");
        preOrderHelper(curr.left);
        preOrderHelper(curr.right);   
    }
 
    public void InOrder(){
        System.out.print("In Order: ");
        inOrderHelper(root);
        System.out.println("");
    }
    
    private void inOrderHelper(BNode curr){ ///  vist, go left, go right
        if (curr==null) return;    
        inOrderHelper(curr.left);
        System.out.print( curr.data+" ");
        inOrderHelper(curr.right);   
    }
    
    public void postOrder(){
        System.out.print("Post Order: ");
        postOrderHelper(root);
        System.out.println("");
    }
    
    private void postOrderHelper(BNode curr){ ///  vist, go left, go right
        if (curr==null) return;  
        postOrderHelper(curr.left);
        postOrderHelper(curr.right); 
        System.out.print( curr.data+" ");  
    }
    
    public void levelOrderTraversal(){
        BNode curr;
        BQueue Q = new BQueue();
        Q.addLast(root);
        while (!Q.empty()){
            curr =Q.removeFront();
            System.out.print(curr.data+" ");
            if (curr.left!=null){
                Q.addLast(curr.left);
            }
            if (curr.right!=null){
                Q.addLast(curr.right);
            }
        }
        System.out.println();
    }
    //search
    public int search(int item){
        BNode curr=root;
        while (curr!=null){
            if (curr.data==item) return curr.data;
            if (item < curr.data) curr= curr.left;
            else curr=curr.right;
        }
        return -1;
    }
    
    public boolean contains(int item){
        BNode curr=root;
        while (curr!=null){
            if (curr.data==item) return true;
            if (item < curr.data) curr= curr.left;
            else curr=curr.right;
        }
        return false;
    }
}


public static void main(String[] args) {
       BinaryTree bt = new BinaryTree();
       bt.insert(100);
       bt.insert(134);
       bt.insert(116);
       bt.insert(157);
       bt.insert(48);
       bt.insert(72);
       bt.insert(23);
       bt.insert(55);
       bt.InOrder();
       bt.preOrder();
       bt.postOrder();
       bt.levelOrderTraversal();
       System.out.println(bt.contains(55));
       System.out.println(bt.contains(87));
       System.out.println(bt.contains(48));
       System.out.println(bt.contains(1009));
  
}



// ******************** Optional auxiliary classes **************
public class BQueue {
    private LNode head;
     
    public BQueue(){
        head=null;
    }
    
    // addLast
    public void addLast(BNode item){
        LNode newNode = new LNode(item);
        LNode curr;
        if (head==null){
            head=newNode;
            return;
        }
        curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }
    
    //remove front
    public BNode removeFront(){
        if (head==null){
            return null;
        }
        BNode temp= head.data;
        head=head.next;
        return temp;    
    }
    
    public boolean empty(){
        return head==null;
    }
}

public class LNode {
    public BNode data;
    public LNode next;
    
    public LNode(BNode data){
        this.data=data;
        this.next=null;
    }
}

