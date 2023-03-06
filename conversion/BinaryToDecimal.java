import java.util.*;
import java.math.*;

public class BinaryToDecimal{
public static double binaryToDecimal(float num){
  int input=(int)num;
    int r,i=0;
    float sum=0,sum2=0;
    int dnum= (int)(((float)(num-input))*100000);
    while(input!=0){
        r=input%10;
        sum=sum+r*(int)Math.pow(2,i);
        i++;
        input/=10;      
    } 
    i=5;
   
    while(i!=0){
        r=dnum%10;
        sum2+=(float)(r*Math.pow(2,-i));      
        dnum/=10;
        i--;         
    }
    sum=sum+sum2;
    return sum;
    
}
    public static void main(String ar[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter binary Number:");
        System.out.println("Decimal eqivalen: "+binaryToDecimal(sc.nextFloat()));
    }
}