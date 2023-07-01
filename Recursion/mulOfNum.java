import java.util.*;
public class mulOfNum {

    public static void mulOfNum(int num,int k){
        if(k==1){
            System.out.print(num+" ");
            return;
        }
        
         mulOfNum(num, k-1);
         System.out.print(num*k+" ");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number and no of times to mutiply");
        int num=sc.nextInt();
        int k=sc.nextInt();
        System.out.println("Output of given input is: ");
        mulOfNum(num, k-1);

    }
}
