import java.util.*;
import java.math.*;
public class BinaryToOctal{
    public static String binaryToOctal(int binary){
       String octal="";int r;
       if(binary==0){
        return "0";
       }
       while(binary!=0){
        int sum=0;
        for(int i=0;i<3;i++){
            r=binary%10;
            binary/=10;
            sum+=r*(Math.pow(2,i));
        }
        octal=sum+octal;
       }
       return octal;
    }
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Binary number ");
        System.out.println("Equivalent Octal number "+binaryToOctal(sc.nextInt()));
        sc.close();
    }
}