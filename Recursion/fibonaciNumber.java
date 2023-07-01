import java.util.Scanner;

public class fibonaciNumber {
       public static int fibonacciNum(int n){
                if(n==0 ||n==1){
                    return n;
                }
                return fibonacciNum(n-1)+fibonacciNum(n-2);
        }   
    public static void main(String[] args) {
        System.out.println("Enter the Number whose fibonacci number to be finded: ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println("It fibonacci Number is: "+fibonacciNum(num)); 
    }
}
