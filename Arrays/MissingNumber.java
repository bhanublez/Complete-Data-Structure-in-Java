import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("Enter size of Array ");
        int sumOfArray=0;
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter value of Arrays");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sumOfArray+=arr[i];
        }
        int sum=(n+1)*(1+n+1)/2;
        System.out.println("Missing number is: "+(sum-sumOfArray));


        
    }
}
