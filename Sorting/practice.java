import java.util.*;

public class practice{
    public static void msort(int a[],int n){
        int temp = new int[n];
        int size=1;
        while(size<=n-1){
        sortpass(a,0,n-1);
        size=size*2;
        }
        
    }
    public static void sortpass(int a[],int temp[],int size,int n){
        int i,low1,low2,up1,up2;
    }
   

    public static void main(String arg[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter no. of element to be inserted in the array:");
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
      msort(arr,n);
        System.out.println("Sorted array as:");

        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }
        sc.close();

    }

}