public class Binary
{


    int binary(int arr[], int l, int r, int key)
    {
        if (r >= l) 
        {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key)
                return mid;    
                // 5 > 40
            if (arr[mid] > key)
                return binary(arr, l, mid-1, key);
            //
            return binary(arr, mid+1, r, key);

        }
        return -1;
    }
    public static void main(String[] args) 
    {
        
        Binary ob = new Binary();
        // huma       1  2  3  4  5   6   7   8   9
        // comp       0  1  2  3  4   5   6   7   87
        int arr[] = { 0, 2, 3, 4, 10, 40, 44, 55, 66 };
        int n = arr.length;
        int key = 66;
        
        int result = ob.binary(arr, 0, n - 1, key);

        if(result == -1)
            System.out.println("element not present");
        else
            System.out.println("Element found at index " + result);
    }
}