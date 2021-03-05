public class Factorial {

    int factorial(int n)
    {
        if(n == 1) return 1;
        if(n >= 2) return n*factorial(n-1);
        else return 0;
    }
    public static void main(String[] args) {
        
        Factorial ob = new Factorial();


        int result = ob.factorial(4);
        System.out.println(result);
    }
}