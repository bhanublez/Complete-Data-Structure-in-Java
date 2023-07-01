import java.util.Scanner;

public class SquareRootOfNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number whose square root to be finded");
        int n=sc.nextInt();
        int result=findSquareRoot(n);
        System.out.println("Square root of given number is: "+result);

    }

    private static int findSquareRoot(int n) {
        int low=0,high=n,result=-1,mid;
        while(low<=high){
            mid=low+(int)(high-low)/2;
            long val=mid*mid;
            if(val==n){
                return mid;
            }else if(val<n){
                result=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return result;
    }
}
