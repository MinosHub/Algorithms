package Hashing;

public class LinearHashTable {
    private String[] table;
    private int tableSize;
    private double loadFactor; //0.80
    int numItems;
    
    public LinearHashTable(int max,double lf){
        table = new String[max];
        tableSize= max;
        for (int x = 0; x<tableSize; x++){
            table[x]="EMPTY";
        }
        loadFactor=lf;
        numItems=0;
    }
    public LinearHashTable(int max){
        table = new String[max];
        tableSize= max;
        for (int x = 0; x<tableSize; x++){
            table[x]="EMPTY";
        }
        loadFactor=0.75;
        numItems=0;
    }
    
    public LinearHashTable(){
        table = new String[20];
        tableSize= 20;
        for (int x = 0; x<tableSize; x++){
            table[x]="EMPTY";
        }
        loadFactor=0.75;
        numItems=0;
    }
    
    private int hashFunction(String word){
        int value=0,weight=1;
        for (int x =0; x<word.length();x++){
            value += (word.charAt(x)-'a'+1)*weight;
            weight++;
        }
        return value%tableSize;
    }
    // insert search delete (update)
    public void insert (String word){
        if (numItems/tableSize < loadFactor){
            int loc =hashFunction(word);  
            while (table[loc].compareTo("EMPTY")!=0 && table[loc].compareTo("DELETED")!=0){
                loc = (loc+1)%tableSize;
            }    
            table[loc]=word;
            numItems++;
        }
    }
    
    public int search(String word){
        int loc = hashFunction(word);  
        while (table[loc].compareTo(word)!=0 && table[loc].compareTo("EMPTY")!=0){
            loc = (loc+1)%tableSize;
        }
        if (table[loc].compareTo("EMPTY")==0)
            return -1;
        return loc;
    }
    
    public void delete(String word){
        int loc = hashFunction(word);  
        while (table[loc].compareTo(word)!=0 && table[loc].compareTo("EMPTY")!=0){
            loc = (loc+1)%tableSize;
        }
        if (table[loc].compareTo("EMPTY")!=0){
            table[loc]="DELETED"; 
            numItems--;
        }
    } 
    
    public void printTable(){
        System.out.println("Hash Table Contents");
        for (int x=0;x<tableSize;x++){
            System.out.println(table[x]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinearHashTable lht = new LinearHashTable();

        lht.printTable();

        lht.insert("andrew");
        lht.insert("farah");
        lht.insert("jeremy");
        lht.insert("micheal");

        lht.printTable();

        lht.delete("andrew");

        lht.printTable();

        lht.insert("andrew");

        lht.printTable();
        
    }
}