import java.util.Scanner;

public class alternateSign {
    public static int alternateSign(int n){
        if(n==0){
            return 0;
        }else if(n%2==0){
            return alternateSign(n-1)-n;
        }else{
            return alternateSign(n-1)+n;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number whose alternate sum to be calculate: ");
        Scanner sc=new Scanner(System.in);
        System.out.println("Alternate sum is: "+alternateSign(sc.nextInt()));

    }
}
