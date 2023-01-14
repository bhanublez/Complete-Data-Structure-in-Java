import java.util.*;
public class Selection_Sort{
public static Scanner sc= new Scanner(System.in);
    public static void Selectionsort(int a[],int n){
        int min,temp;
        for(int i=0;i<n;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]){
                    min=j;
                }
                if(i!=min){
                    temp=a[i];
                    a[i]=a[min];
                    a[min]=temp;
                }
            }
        }

    }
    public static void main(String arg[]){
        System.out.println("Enter no. of element to be inserted in the array:");
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        Selectionsort(arr,n);
       

        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }

    }

}