package Hashing;

public class Main {
    public static void main(String[] args) {
        
        /*
        Linear testing starts here
        */
        
        // LinearHashTable lht = new LinearHashTable(); // current sample no arguments passed
        QuadHashTable lht = new QuadHashTable(); // current sample no arguments passed
        
        // lht.insert("andrew");                         // adding andrew
        // lht.insert("farah");                        // adding farah
        // lht.insert("jeremy");                       // adding jeremy
        // lht.insert("micheal");                      // adding michael
    
        // lht.printTable();
    
        // below code is commented temporarily
        // lht.delete("andrew");                    // delete andrew
        // lht.printTable();                        
        lht.insert("andrew", 123, "something");                    // insert andrew
        lht.insert("andrew", 321, "something");                    // insert andrew
        lht.insert("andrew", 321, "otherthing");                    // insert andrew
        lht.insert("andrew", 321, "lola");                    // insert andrew
        lht.insert("mino", 321, "otherthing");                    // insert andrew

        lht.delete("andrew", 123, "something");
        lht.delete("andrew", 321, "something");
        // lht.delete("andrew");

        System.out.println(lht.search("mino", 321, "otherthing"));

        lht.printTable();

        // *****************************************************************

        /*
        QuadHashTable testing starts here
        */

        // QuadHashTable qht = new QuadHashTable();

        // qht.printTable();

    }
}
