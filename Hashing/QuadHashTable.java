package Hashing;

public class QuadHashTable {
    private static final String EMPTY = "EMPTY";    // this is the EMPTY constant that assigns to the deleting item
    private String[] table;                         //  this is the array
    private int tableSize;                          //  this is the size of the table
    private double loadFactor;                      // this is the load factor 0.80 (80%) the range is 75-80% or less to keep the database consistent
    int numItems;                                   // this variable will keep track of the table content that are not EMPTY ot DELETED

    public QuadHashTable(int max,double lf){      //overloaded when there are 2 arguments(int, double) passed
        table = new String[max];                    // this will create a new array called table with the int passed to the function
        tableSize = max;                            // this will assign tableSize to max
        // for (int x = 0; x < tableSize; x++){        
        //     table[x] = EMPTY;                       // assigning all elements of the table top EMPTY
        // }
        loadFactor = lf;                            // load factor assigning to the double passed in function
        numItems = 0;                               // numItems is a counter to keep track of (active) items in the table
    }
                        //tableSize
    public QuadHashTable(int max){                //overloaded when there is one argument(int) passed
        table = new String[max];                    
        tableSize = max;                    
        // for (int x = 0; x < tableSize; x++){
        //     table[x] = EMPTY;
        // }
        loadFactor = 0.75;                          // load factor is default 0.75(75%) when no argument is passed to it 
        numItems = 0;   
    }
    
    public QuadHashTable(){                       //overloaded when arguments are not passed | current sample in main
        table = new String[20];                     // default (value for the table is 20 when nothing is passed to the function)
        tableSize = 20;                             // default
        // for (int x = 0; x < tableSize; x++){
        //     table[x] = EMPTY;
        // }
        loadFactor = 0.75;                          // default
        numItems = 0;
    }
    
    private int hashFunction(String word){          // this is the hash function
        int value = 0;                              // value will be assigned with a hashed number
        int weight = 1;                             // weight will keep count to the position of the letter
        for (int x = 0; x < word.length(); x++){    // iterates through the string to the length of the passed string               
            value += (word.charAt(x) - 'a' + 1) * weight;  // assigns value to the ((size of char - 'size of char(a)') * weight) //  aaa 1x1 + 1x2 + 1x3 = 6
            weight++;                               // iterates to keep track of char position           (for example)           //  aaa 1x1 + 1x2 + 1x3 = 6
        }
        return value % tableSize;                   // return int value of the item position 6%20(default) = 6
    }

    

    private int hashFunctionThreeWords(String name, String accountNum, String other){          // this will work for accountNum if it was String
        int value = 0;                              
        int weight1 = 1;                                                         
        int weight3 = 1;                       
             
        for (int x = 0; x < name.length(); x++){       
            value += (name.charAt(x) - 'a' + 1) * weight1;  
            weight1++;                               
        }            

        value += Integer.parseInt(accountNum);

        for (int x = 0; x < other.length(); x++){    // iterates through the string to the length of the passed string               
            value += (other.charAt(x) - 'a' + 1) * weight3;  
            weight3++;                               
        }

        return value % tableSize;                  
    }

    private int hashFunctionThreeWords(String name, int accountNum, String other){          // this will work for accountNum if it was INT
        int value = 0;                              
        int weight1 = 1;                                                        
        int weight3 = 1;                             
        for (int x = 0; x < name.length(); x++){       
            value += (name.charAt(x) - 'a' + 1) * weight1;  
            weight1++;                               
        }

        value += accountNum;                 // int are already unique deterministically       
                              
        for (int x = 0; x < other.length(); x++){    // iterates through the string to the length of the passed string               
            value += (other.charAt(x) - 'a' + 1) * weight3;  
            weight3++;                               
        }
        
        return value % tableSize;                  
    }

    // insert search delete (update)
    public void insert (String word){               // this is the inserting function
        if (numItems / tableSize < loadFactor){
            int loc = hashFunction(word);           // this is 6 based on our default calculations
            while (table[loc] != null && table[loc].compareTo("DELETED") != 0){    // if location[6] is not "empty" && and location[6] is not "deleted"    
                loc = (loc + 1) % tableSize;                                                     // (loc(6) + 1) % tableSize(20) = 7
            }
            // araz = 7 = loc
            // 0 = true
            // 1 = false
            // (example)
            // 1 == 1 = true
            // 1 != 1 = false
            // 1 != 0 = true
            // 0 != 0 = false
            table[loc] = word;
            numItems++;
        }
    }
    //table
    //7 Araz
    //6 Mino
    //5 Hovsep
    //4 EMPTY
    //3 Talin
    //2 EMPTY
    //1 EMPTY
    //0 EMPTY  
    public int search(String word){                 // this is the search function
        int loc = hashFunction(word);  
        while (table[loc].compareTo(word) != 0 && table[loc] != null){
            loc = (loc + 1) % tableSize;
        }
        if (table[loc] == null)
            return -1;
        return loc;
    }
    
    public void delete(String word){                // this is the deleting function
        int loc = hashFunction(word);  
        while (table[loc].compareTo(word) != 0 && table[loc] != null){
            loc = (loc + 1) % tableSize;
        }
        if (table[loc] != null){
            table[loc] = "DELETED"; 
            numItems--;
        }
    } 
    
    public void printTable(){                       // this is the printing function
        System.out.println("Hash Table Contents");
        for (int x = 0; x < tableSize; x++){
            if (table[x] != null)
            {
                System.out.println(table[x]);                
            }
            else
            {
                System.out.println("EMPTY");
            }       
        }
        System.out.println("");
    }
}
