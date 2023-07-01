import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LowerBound {
    public static void main(String[] args) {
        Random random=new Random();
        IntStream intstream=random.ints(0,100);
        int []arr= intstream.limit(10).toArray();
        Arrays.sort(arr);        
        System.out.println(Arrays.toString(arr));

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the target: ");
        int target =sc.nextInt();
        int flag=0;

        //Approach 1 Linear Search
        /*
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                System.out.println("Target is founded at index: "+i);
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("Target is not founded in given array: ");
        }
        */

        //Approach 2 Binary Search
        int low=0,high=arr.length,result=-1,mid=0;
        while(low<high){
            mid=low+(int)(high-low)/2;
            if(arr[mid]==target){
                result=mid;
                high=mid-1;
            }else if(arr[mid]>target){
                high=mid-1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
        }

        if(result!=-1){
            System.out.println("Tareget is founded at index: "+result);
        }
    }
}
