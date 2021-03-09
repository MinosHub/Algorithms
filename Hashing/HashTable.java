package Hashing;

public class HashTable {

    String[] table;
    int tableSize;
    
    public HashTable(int n){
        table = new String[n];
        tableSize = n;
        for ( int x = 0;x<tableSize;x++){
            table[x]="EMPTY";
        }
    }
    
    public int hashFunction(String word){
        int value=0;
        for ( int x=0;x<word.length();x++){
            value += word.charAt(x)-'a';
        }
        return value % tableSize;
    }
    
    public void insert(String word){
        int loc = hashFunction(word);
        while (table[loc]!="EMPTY" && table[loc]!="DELETED"){
            loc = (loc+1)%tableSize;
        }
        table[loc] = word;
    }
    
    public int search(String word){
        int loc = hashFunction(word);
        while (table[loc].compareTo(word)!=0 && table[loc].compareTo("EMPTY")!=0){
           loc = (loc+1)%tableSize; 
        }
        if (table[loc].compareTo("EMPTY")!=0){
            return loc;
        }
        return -1;
    }
    
    public void delete (String word){
        int loc = hashFunction(word);
        while (table[loc].compareTo(word)!=0 && table[loc].compareTo("EMPTY")!=0){
           loc = (loc+1)%tableSize; 
        }
        if (table[loc].compareTo("EMPTY")!=0){
            table[loc]="DELETED";
        }
    }
    
    public void printTable(){
        System.out.println("Table Values");
        for (int x=0; x<tableSize;x++){
            System.out.println(x + " # " + table[x]);
        }
        System.out.println("");
    }


public static void main(String[] args) {
       
        HashTable ht = new HashTable(12);
        ht.printTable();
        ht.insert("apple");
        ht.insert("pear");
        ht.insert("add");
        ht.insert("dda");
        ht.printTable();
}
}