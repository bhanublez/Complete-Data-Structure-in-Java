import java.util.*;
import java.math.*;
public class OctalToBinary{
    public static String octalToBinary(int octal){
        int r;String binary="";
        if(octal==0){
            return "0";
        }
        while(octal!=0){
            r=octal%10;
            octal/=10;
            if(r==0){
                binary="000"+binary;
            }else if(r==1){
                binary="001"+binary;
            }else if(r==2){
                binary="010"+binary;
            }else if(r==3){
                binary="011"+binary;
            }else if(r==4){
                binary="100"+binary;
            }else if(r==5){
                binary="101"+binary;
            }else if(r==6){
                binary="110"+binary;
            }else if(r==7){
                binary="111"+binary;
            }
        }
        return binary;
    }
    public static void main(String ar[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Octal Number");
        int input=sc.nextInt();
        System.out.println("Equivalent Binary Number "+octalToBinary(input));

    }
}