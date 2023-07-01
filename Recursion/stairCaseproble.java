import java.util.Scanner;

public class stairCaseproble {

    public static int numOfWays(int num){
        int result=0;
        int step1=1,step2=2;
        if(num==1 || num==2){
            return num;
        }else if(num==0){
            return 0;
        }else{
            return numOfWays(num-1)+numOfWays(num-2);
        }    
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of stairs");
        int num=sc.nextInt();
        System.out.println("Number of ways cover stairs is: "+numOfWays(num));
        
    }
}
