import java.util.Scanner;

public class sumOfDigit {

    public static int sumOfDigit(int num){
        int result=0;
        if((int)num/10==0){
            return num;
        }else{
            return num%10 +sumOfDigit(num/10);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Digit whose sum to be calculated: ");
        int num=sc.nextInt();
        System.out.println("Sum of Digits is: "+sumOfDigit(num));        
    }
}
