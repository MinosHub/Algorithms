package Hashing;

public class DoubleHashTable {

    private static final String EMPTY = "EMPTY";    // this is the EMPTY constant that assigns to the deleting item
    private Car[] table;                         //  this is the array
    private int tableSize;                          //  this is the size of the table
    private double loadFactor;                      // this is the load factor 0.80 (80%) the range is 75-80% or less to keep the database consistent
    int numItems;                                   // this variable will keep track of the table content that are not EMPTY ot DELETED

    public DoubleHashTable(int max,double lf){      //overloaded when there are 2 arguments(int, double) passed
        table = new Car[max];                    // this will create a new array called table with the int passed to the function
        tableSize = max;                            // this will assign tableSize to max
        loadFactor = lf;                            // load factor assigning to the double passed in function
        numItems = 0;                               // numItems is a counter to keep track of (active) items in the table
    }
                        //tableSize
    public DoubleHashTable(int max){                //overloaded when there is one argument(int) passed
        table = new Car[max];                    
        tableSize = max;                    
        loadFactor = 0.80;                          // load factor is default 0.75(75%) when no argument is passed to it 
        numItems = 0;   
    }
    
    public DoubleHashTable(){                       //overloaded when arguments are not passed | current sample in main
        table = new Car[80];                     // default (value for the table is 20 when nothing is passed to the function)
        tableSize = 80;                             // default
        loadFactor = 0.80;                          // default
        numItems = 0;
    }
    


    // hashing 

    private int hashFunction2(Car obj){          // this is the hash function
        int value = 0;                              // value will be assigned with a hashed number
        int weight = 1;                             // weight will keep count to the position of the letter
        for (int x = 0; x < obj.make.length(); x++){    // iterates through the string to the length of the passed string               
            value += (obj.make.charAt(x) - 'a' + 1) * weight;  // assigns value to the ((size of char - 'size of char(a)') * weight) //  aaa 1x1 + 1x2 + 1x3 = 6
            weight++;                               // iterates to keep track of char position           (for example)           //  aaa 1x1 + 1x2 + 1x3 = 6
        }

        for (int x = 0; x < obj.model.length(); x++){    // iterates through the string to the length of the passed string               
            value += (obj.model.charAt(x) - 'a' + 1) * weight;  // assigns value to the ((size of char - 'size of char(a)') * weight) //  aaa 1x1 + 1x2 + 1x3 = 6
            weight++;                               // iterates to keep track of char position           (for example)           //  aaa 1x1 + 1x2 + 1x3 = 6
        }

        value += obj.oilLevel;

        for (int x = 0; x < obj.vin.length(); x++){    // iterates through the string to the length of the passed string               
            value += (obj.vin.charAt(x) - 'a' + 1) * weight;  // assigns value to the ((size of char - 'size of char(a)') * weight) //  aaa 1x1 + 1x2 + 1x3 = 6
            weight++;                               // iterates to keep track of char position           (for example)           //  aaa 1x1 + 1x2 + 1x3 = 6
        }
        return value % tableSize;                   // return int value of the item position 6%20(default) = 6
    }

    private int hashFunction(Car obj){          // this is the hash function
        int value = 0;
        int weight = 1;                           // this is not being used in this version
        for (int x = 0; x < obj.make.length(); x++){    // iterates through the string to the length of the passed string               
            value += obj.make.charAt(x);  
        }

        for (int x = 0; x < obj.model.length(); x++){    // iterates through the string to the length of the passed string               
            value += obj.model.charAt(x);  
        }
        
        value += obj.oilLevel;

        for (int x = 0; x < obj.vin.length(); x++){    // iterates through the string to the length of the passed string               
            value += obj.vin.charAt(x);  
        }
        return value % (tableSize/2);                   
    }





    // CRUDS methods

    // insert search delete (update)
    public boolean insert (Car obj){               // this is the inserting function
        if (numItems / tableSize < loadFactor){
            int loc = hashFunction(obj);    
            int inc = hashFunction2(obj);       
            while (table[loc] != null && table[loc].tracker == "DELETED"){    // if location[6] is not "empty" && and location[6] is not "deleted"    
                loc = (loc + inc) % tableSize;                                                     // (loc(6) + 1) % tableSize(20) = 7
            }
            table[loc] = obj;  // finally storing value to table (depending on presentation obj.member can vary)
            table[loc].tracker = "";
            numItems++;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int search(Car obj){                 // this is the search function
        int loc = hashFunction(obj);  
        int inc = hashFunction2(obj);  
             
        while (table[loc].make.compareTo(obj.make) != 0 && table[loc] != null){
            loc = (loc + inc) % tableSize;
        }
        if (table[loc] == null)
            return -1;
        return loc;
    }

    public boolean update(Car obj, int oil){                 // this is the search function
        int loc = hashFunction(obj);  
        int inc = hashFunction2(obj);  

        while (table[loc].make.compareTo(obj.make) != 0 && table[loc] != null){
            loc = (loc + inc) % tableSize;
        }
        if (table[loc] == null)
            return false;
        else
        {
            obj.oilLevel = oil;
            return true;
        }
    }
    
    public boolean delete(Car obj){                
        int loc = hashFunction(obj);  
        int inc = hashFunction2(obj);       
        while (table[loc].make.compareTo(obj.make) != 0 && table[loc] != null){
            loc = (loc + inc) % tableSize;
        }
        if (table[loc] != null){
            table[loc].tracker = "DELETED";
            table[loc] = null;
            numItems--;
            return true;
        }
        else
        {
            return false;
        }  
    } 
    
    public void printTable(){                       // this is the printing function
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
