package Hashing;

public class Main {
    public static void main(String[] args) {
        
        /*
        Linear testing starts here
        */
        Account acc1 = new Account("andrew", 123, "something");
        Account acc2 = new Account("araz", 123, "something");
        Account acc3 = new Account("mino", 123, "something");
        Account acc4 = new Account("talin", 123, "something");


        // LinearHashTable lht = new LinearHashTable(); // current sample no arguments passed
        QuadHashTable lht = new QuadHashTable(); // current sample no arguments passed
        
        lht.insert(acc1);                         // adding andrew
        lht.insert(acc2);                         // adding andrew
        lht.insert(acc3);                         // adding andrew
        lht.insert(acc4);                         // adding andrew
    
        lht.delete(acc1);

        

        lht.printTable();
    

        // lht.delete("andrew", 123, "something");
        // lht.delete("andrew", 321, "something");
        // // lht.delete("andrew");

        // System.out.println(lht.search("mino", 321, "otherthing"));

        // lht.printTable();

    }
}
