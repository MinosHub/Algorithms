package Hashing;

public class QuadHashTable {
    private String[] table;                         //  this is the array
    private int tableSize;                          //  this is the size of the table
    private double loadFactor;                      // this is the load factor 0.80 (80%) the range is 75-80% or less to keep the database consistent
    int numItems;                                   // this variable will keep track of the table content that are not EMPTY ot DELETED


    // constructors overloaded

    public QuadHashTable(int max,double lf){      //overloaded when there are 2 arguments(int, double) passed
        table = new String[max];                    // this will create a new array called table with the int passed to the function
        tableSize = max;                            // this will assign tableSize to max
        loadFactor = lf;                            // load factor assigning to the double passed in function
        numItems = 0;                               // numItems is a counter to keep track of (active) items in the table
    }
                        //tableSize
    public QuadHashTable(int max){                //overloaded when there is one argument(int) passed
        table = new String[max];                    
        tableSize = max;                    
        loadFactor = 0.75;                          // load factor is default 0.75(75%) when no argument is passed to it 
        numItems = 0;   
    }
    
    public QuadHashTable(){                       //overloaded when arguments are not passed | current sample in main
        table = new String[20];                     // default (value for the table is 20 when nothing is passed to the function)
        tableSize = 20;                             // default
        loadFactor = 0.75;                          // default
        numItems = 0;
    }
    



    // hash function segment

    // private int hashFunction(String word){          // this is the hash function
    //     int value = 0;                              // value will be assigned with a hashed number
    //     int weight = 1;                             // weight will keep count to the position of the letter
    //     for (int x = 0; x < word.length(); x++){    // iterates through the string to the length of the passed string               
    //         value += (word.charAt(x) - 'a' + 1) * weight;  // assigns value to the ((size of char - 'size of char(a)') * weight) //  aaa 1x1 + 1x2 + 1x3 = 6
    //         weight++;                               // iterates to keep track of char position           (for example)           //  aaa 1x1 + 1x2 + 1x3 = 6
    //     }
    //     return value % tableSize;                   // return int value of the item position 6%20(default) = 6
    // }

    



    // 3 inputs hashing segment + overloaded version for int below

    private int hashFunctionThreeWords(String name, String accountNum, String other){          // this will work for accountNum if it was String
        int value = 0;                              
        int weight1 = 1;                                                         
        int weight3 = 1;         

        // there is an exception 
             
		for (int x = 0; x < name.length(); x++) {
        
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

		value += accountNum;  // int are already unique deterministically
                            
        for (int x = 0; x < other.length(); x++){    // iterates through the string to the length of the passed string               
            value += (other.charAt(x) - 'a' + 1) * weight3;  
            weight3++;                               
        }
        
        return value % tableSize;                  
    }

    // insert search delete (update)
    // public void insert (String word, int accountNum, String other){
    //     if (numItems/tableSize < loadFactor){
    //         int count = 1;
    //         int startLoc = hashFunctionThreeWords(word, accountNum, other);             // change this function name according to the requirements given
    //         int loc = startLoc;
    //         while (table[loc]!=null && table[loc].compareTo("DELETED")!=0){
    //             loc = (startLoc + count*count)%tableSize;
    //             count++;
    //         }    
    //         table[loc] = word;
    //         numItems++;
    //     }
    // }
    
    //
    public void insert (Account obj){
        if (numItems/tableSize < loadFactor){
            int count = 1;
            int startLoc = hashFunctionThreeWords(obj.accountName, obj.accountNum, obj.otherVariable);             // change this function name according to the requirements given
            int loc = startLoc;
            while (table[loc]!=null && table[loc].compareTo("DELETED")!=0){
                loc = (startLoc + count*count)%tableSize;
                count++;
            }    
            table[loc] = obj.accountName;
            numItems++;
        }
    }
 
	public int search(Account obj) {
		int count = 1;

		int startLoc = hashFunctionThreeWords(obj.accountName, obj.accountNum, obj.otherVariable);              // change this function name according to the requirements given
		int loc = startLoc;

		while (table[loc] != null && table[loc].compareTo(obj.accountName) != 0) {                              // this needs to be revisited depending on the requirements
			loc = (startLoc + count * count) % tableSize;
			count++;
		}
		if (table[loc] == null)
			return -1;
		return loc;
	}


    public void delete(Account obj){
        
        int count = 1;
        int startLoc = hashFunctionThreeWords(obj.accountName, obj.accountNum, obj.otherVariable);          // change this function name according to the requirements given
        int loc = startLoc; 
        // startLoc above can be replaced with a search call. When the value returns -1 it means the position is null or deleted which leads to the if statement below (alternative code)
        
        while (table[loc]!=null && table[loc].compareTo(obj.accountName)!=0){
            loc = (startLoc + count*count) % tableSize;
            count++;
        }
        if (table[loc] != null){                                                        // this can check for -1 and if it is true confirms item has been deleted and decrements numItems (alternative code)
            table[loc] = "DELETED"; 
            numItems--;
        }
    } 
    
    public void printTable(){                       
        System.out.println("Hash Table Contents");
        for (int x = 0; x < tableSize; x++){
            if (table[x] != null)
            {
                System.out.println(x + " - " + table[x]);                
            }
            else
            {
                System.out.println(x + " - " + "EMPTY");
            }       
        }
        System.out.println("");
    }
}
