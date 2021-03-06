public class Insertion 
{
    void sort(int arr[])
    {
        int token = arr.length;
        for (int i = 0; i < token; i++)
        {
            int key = arr[i];                           //swap 1                                      
            int j = i - 1;  // j is -1 the size of i
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];                      // swap 2
                j = j - 1; // decrementing j
            }
            arr[j+1] = key;                             // swap 3 finished
            System.out.print("Step: " + (i+1) + " |#| ");                           
            printArray(arr);
        }
    }

    void sortReverse(int arr[])
    {
        int token = arr.length;
        for (int i = 0; i < token; i++)
        {
            int key = arr[i];                           //swap 1                                      
            int j = i - 1;  // j is -1 the size of i
            while (j >= 0 && arr[j] < key)
            {
                arr[j+1] = arr[j];                      // swap 2
                j = j - 1; // decrementing j
            }
            arr[j+1] = key;                             // swap 3 finished
            System.out.print("Step: " + (i+1) + " |#| ");                           
            printArray(arr);
        }
    }

    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();        
    }
    
    public static void main(String[] args) 
    {
        int arr[] = { 64,-6,44,25,37,7,29,-22,12,-18 };

        Insertion ob = new Insertion();
        
        System.out.println("**********");
        System.out.println("ASC");
        printArray(arr);
        System.out.println("**********");
        
        ob.sort(arr);

        System.out.println("**********");
        printArray(arr);
        System.out.println("**********");

        //desc
        System.out.println("**********");
        System.out.println("DESC");
        printArray(arr);
        System.out.println("**********");
        
        ob.sortReverse(arr);

        System.out.println("**********");
        printArray(arr);
        System.out.println("**********");
    }
}