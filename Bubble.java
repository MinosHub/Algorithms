import org.graalvm.compiler.core.common.cfg.PrintableCFG;

import jdk.internal.jshell.tool.resources.l10n;

/**
 * bubble
 */
public class Bubble {

    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < (n-1); i++) {
            for (int j = 0; j < (n-i-1); j++) {
                if (arr[j] > arr[j+1]) 
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;    
                }
                printArray(arr);
            }
        }
    }

    void sortReverse(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < (n-1); i++) {
            for (int j = 0; j < (n-i-1); j++) {
                if (arr[j] < arr[j+1]) 
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;    
                }
                printArray(arr);
            }
        }
    }
    
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        
        Bubble ob = new Bubble();
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
        int arr_1[] = {5,1,4,2,8};

        ob.printArray(arr_1);
        System.out.println();
        ob.sort(arr_1); // this is asc order // to do desc just call sortReverse

        System.out.println();
        ob.printArray(arr_1);
    }
}