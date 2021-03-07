public class Binary
{


    int binary(int arr[], int l, int r, int key)
    {
        int mid = 0;
        if (r >= l) 
        {
            mid = l + (r - l) / 2;
            if (arr[mid] == key){

                System.out.println("Mid = " + mid);
                System.out.println("Lo = " + l);
                System.out.println("Hi = " + r);

                return mid;    
            }
                // 5 > 40
            if (arr[mid] > key) // asc works with > | desc works with <
                return binary(arr, l, mid-1, key);
            //
            return binary(arr, mid+1, r, key);

        }

        System.out.println("Mid = " + mid);
        System.out.println("Lo = " + l);
        System.out.println("Hi = " + r);

        return -1;
    }

    // I would like to find out the values of mid, r, l and return value of the found index 
    // also check the descending and (ascending if exits) to 

    // both of the above comments are fixed now and performing without problems.


    public static void main(String[] args) 
    {
        
        Binary ob = new Binary();
        // index      1  2  3  4  5   6   7   8   9
        int arr[] = { 0, 2, 3, 4, 10, 40, 44, 55, 66 };
        // int arr[] = { 66,55,44,40,10,4,3,2,0 }; // this one is just reversed of the above to experiment with
        int n = arr.length;
        int key = 3;
        
        int result = ob.binary(arr, 0, n - 1, key);

        if(result == -1)
            System.out.println("element not present");
        else
            System.out.println("Element found at index " + result);
    }
}