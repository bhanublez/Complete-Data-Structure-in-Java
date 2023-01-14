import java.util.Scanner;

public class Bubble_Sort{
    public static void bubblesort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String arg[]){
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of Elemrnt to be enter in the array:");
        n=sc.nextInt();
        int arr[] =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        bubblesort(arr,n);
      
        System.out.println("Sorted array as: ");
        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }
        sc.close();

    }
} 