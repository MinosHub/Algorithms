public class Merge {

    void merge(int arr[], int l, int m, int r){
        // find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays
        
        // initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // initial index of merged subarray array
        int k = l;
        
        while (i < n1 && j < n2){
            if (L[i] <= R[j]) { // this is the reversing check line.
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of L[] if any
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
        // copy remaining elements of R[] if any
        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeReverse(int arr[], int l, int m, int r){
        // find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays
        
        // initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // initial index of merged subarray array
        int k = l;
        
        while (i < n1 && j < n2){
            if (L[i] >= R[j]) { // this is the reversing check line.
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of L[] if any
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
        // copy remaining elements of R[] if any
        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    void sort(int arr[], int l, int r){
        if(l < r){
            // printArray(arr);
            int m = l + (r-l) / 2;
            
            sort(arr, l, m);
            sort(arr, m + 1, r);
            
            merge(arr, l, m, r);
            printArray(arr);
        }
    }

    void sortReverse(int arr[], int l, int r){
        if(l < r){
            int m = l + (r-l) / 2;
            
            sortReverse(arr, l, m);
            sortReverse(arr, m + 1, r);
            
            mergeReverse(arr, l, m, r);
            printArray(arr);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        
        Merge ob = new Merge();

        int arr[] = { 38,27,43,3,9,82,10 };
        System.out.println("Unsorted");
        printArray(arr);
        System.out.println();
        
        System.out.println("\nAscending");
        printArray(arr);
        ob.sort(arr, 0, arr.length - 1);
        System.out.println();
        

        System.out.println("\nDescending");
        printArray(arr);
        ob.sortReverse(arr, 0, arr.length - 1);
        System.out.println();

    }
}
