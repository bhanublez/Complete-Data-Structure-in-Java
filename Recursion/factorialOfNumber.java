
import java.util.Scanner;

public class factorialOfNumber {
    public static int factorialOfNumber(int n){
        int result=0;
        if(n==0 || n==1){
            return 1;
        }
        return n*factorialOfNumber(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Enter the Number whose factorial needed to be finded: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Factorial of "+n+" is: "+factorialOfNumber(n));
     }
}
