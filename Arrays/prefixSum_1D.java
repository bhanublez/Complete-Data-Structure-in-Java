import java.util.*;
public class prefixSum_1D{
    public static int prefixSum(int arr[],int index){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<=index;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static void main(String aa[]){
        System.out.println("Enter the size of arrray");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the Element of array:");
        for(int i=0;i<n;i++ ){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the index till which prefix sum wanted:");
        int index=sc.nextInt();
        System.out.println("Required Prefix sum is: "+prefixSum(arr,index));
    }

}