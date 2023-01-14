import java.util.*;
public class Insertion_Sort{
    public static void Insertionsort(int arr[],int n){
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0&&key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

    }
   public static Scanner sc= new Scanner(System.in);
    public static void main(String arg[]){
        System.out.println("Enter no. of element to be inserted in the array:");
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        Insertionsort(arr,n);


        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }

    }

}