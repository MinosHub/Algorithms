public class Selection 
{
    void sort(int arr[])
    {
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int min_indx = i;
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[j] < arr[min_indx])
                {
                    min_indx = j;    
                }    
            }    
            
            //swap
            int temp = arr[min_indx]; // min_indx is the smallest value index number
            arr[min_indx] = arr[i]; // this is the swap
            arr[i] = temp; // temp is the smallest value;
            printArray(arr);
        }

    }
    
    void sortReverse(int arr[])
    {
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int min_indx = i;
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[j] > arr[min_indx])
                {
                    min_indx = j;    
                }    
            }    
            
            //swap
            int temp = arr[min_indx]; // min_indx is the smallest value index number
            arr[min_indx] = arr[i]; // this is the swap
            arr[i] = temp; // temp is the smallest value;
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

    //members and methods...
    public static void main(String[] args) 
    {
        
        int arr[] = {64, 25, 12, 22, 11};

        Selection ob = new Selection();

        System.out.println("**********");
        System.out.println("ASC");
        printArray(arr);
        System.out.println("**********");
        ob.sort(arr);

        System.out.println("**********");
        printArray(arr);
        System.out.println("**********");

        // desc
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
