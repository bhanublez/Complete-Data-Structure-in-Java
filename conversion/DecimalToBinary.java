import java.util.*;
public class DecimalToBinary{
    public static int decimalToBinary(int q){
        int sum=0,i,r,c=0;
        while(q!=0){
            r=q%2;
            sum+=(int)r*Math.pow(10,c++);
            q/=2;
        }
        return sum;
    }
    public static void main(String ar[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter decimal number ");
        System.out.println("Eqivalent Binary number "+decimalToBinary(sc.nextInt()));
    }
}