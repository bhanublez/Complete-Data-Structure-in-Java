import java.util.*;
import java.math.*;

public class BinaryToHexa{
    public static String binaryToHexa(int binary){
        String hexa="";
        int sum=0,r;char ch;
        if(binary==0){
            return "0";
        }
        while(binary!=0){
            sum=0;
           for(int i=0;i<4;i++){
            r=binary%10;
            binary/=10;
            sum+=r*Math.pow(2,i);
           }
           if(sum==10){
            hexa='A'+hexa;
        }else if(sum==11){
            hexa='B'+hexa;
        }else if(sum==12){
            hexa='C'+hexa;
        }else if(sum==13){
            hexa='D'+hexa;
        }else if(sum==14){
            hexa='E'+hexa;
        }else if(sum==15){
            hexa='F'+hexa;
        }else{
            hexa=sum+hexa;
        }
          
        }
       
        return hexa;
    }

    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter binary number");
        int input=sc.nextInt();
        System.out.println("Equivalent Hexa Number "+binaryToHexa(input));
    }
}