package Hashing;

public class Main {
    public static void main(String[] args) {
        
        /*
        Account objects initialized with data passed to constructor
        */
        Account acc1 = new Account("andrew", 123, "something");
        Account acc2 = new Account("araz", 123, "something");
        Account acc3 = new Account("mino", 123, "something");
        Account acc4 = new Account("talin", 123, "something");

        QuadHashTable lht = new QuadHashTable(); // current sample no arguments passed
        
        lht.insert(acc1);                         // adding andrew
        lht.insert(acc2);                         // adding andrew
        lht.insert(acc3);                         // adding andrew
        lht.insert(acc4);                         // adding andrew
    

        lht.search(acc2);

        // lht.delete(acc1);

        lht.printTable();

        System.out.println(lht.search(acc2));           // debug search object
        
        System.out.println(acc2.otherVariable);         // debug object.member

    }
}
