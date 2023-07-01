import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearch {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream intStream = random.ints(0, 100);
        int[] array = intStream.limit(10).toArray();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Enter the digit whose index to be finded: ");
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        int low=0,i=0,flag=0;
        int high=array.length;
        int mid=low+(int)(high-low)/2;
        while(low<=high){
            mid=low +(int)(high-low)/2;
            if(array[mid]==x){
                flag=1;
                System.out.println("Element is founded at index "+(mid));
                break;
            }else if(array[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Element is not founded in given array ");
        }
        


    }
}
