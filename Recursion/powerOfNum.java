import java.math.BigInteger;
import java.util.*;
public class powerOfNum {

    //Brute force Approach
    // public static int powerOfNumber(int a,int b){
    //     if(b==1){
    //         return a;
    //     }
    //     if(b==0){
    //         return 1;
    //     }
    //     return a*powerOfNumber(a, b-1);
    // }

    //Optimized Approach
    public static BigInteger powerofNum(BigInteger a,int b){
        BigInteger result,finalresult;
        if(b==1){
            return a;
        }
        else{
            result=powerofNum(a, b/2);
            finalresult=result.multiply(result);
            
        }
        if(b%2==0){
            return finalresult;
        }else{
            return finalresult.multiply(a);
        }
        
    }
 public static void main(String[] args) {
    System.out.println("Enter the Number and it power: ");
    Scanner sc=new Scanner(System.in);
    BigInteger a=sc.nextBigInteger();
    int b=sc.nextInt();
    // System.out.println("Result is: "+powerOfNumber(a,b));
    System.out.println("Result is: "+powerofNum(a,b));
 }   
}
