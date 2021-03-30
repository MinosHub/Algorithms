package Hashing;

public class Main {
    public static void main(String[] args) {
        
        /*
        Account objects initialized with data passed to constructor
        */
        // Account acc1 = new Account("andrew", 123, "something");
        // Account acc2 = new Account("anubis", 123, "something");
        // Account acc3 = new Account("mino", 123, "something");
        // Account acc4 = new Account("apollo", 123, "something");
        // Account acc5 = new Account("andrew", 123, "something");
        // Account acc6 = new Account("araz", 123, "something");
        // Account acc7 = new Account("mino", 123, "something");
        // Account acc8 = new Account("talin", 123, "something");
        Car acc8 = new Car("bmw", "m5", "123qwe", 123234);

        DoubleHashTable lht = new DoubleHashTable(); // current sample no arguments passed
        
        // lht.insert(acc1);                         
        // lht.insert(acc2);                         //
        // lht.insert(acc3);                         //  
        // lht.insert(acc4);                         //  
        // lht.insert(acc5);                         //  
        // lht.insert(acc6);                         //  
        // lht.insert(acc7);                         //  
        lht.insert(acc8);                         //  
        lht.delete(acc8);
        lht.insert(acc8);                         //
        System.out.println(lht.search(acc8));
        lht.update(acc8, 123);
        System.out.println(acc8.oilLevel);
        
        

    

        // lht.search(acc2);

        // lht.delete(acc1);
        // lht.delete(acc2);
        // lht.delete(acc3);

        lht.printTable();

        // System.out.println(lht.search(acc2));           // debug search object
        
        // System.out.println(acc2.otherVariable);         // debug object.member

    }
}
