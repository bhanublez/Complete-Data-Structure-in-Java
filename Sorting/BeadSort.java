import java.util.*;
public class BeadSort{
    public static int[] sort(int[] unsorted) {
        int[] sorted = new int[unsorted.length];
        int max = 0;
        for(int i = 0; i < unsorted.length; i++) {
        max = Math.max(max, unsorted[i]);
        }
    
        char[][] grid = new char[unsorted.length][max];
        int[] count = new int[max];
    
        for(int i = 0; i < unsorted.length; i++) {
            for(int j = 0; j < max; j++) {
                grid[i][j] = '-';
             }
         }
    
        for(int i = 0; i < max; i++) {
            count[i] = 0;
        }
    
            for(int i = 0; i < unsorted.length; i++) {
                int k = 0;
                for(int j = 0; j < (int) unsorted[i] ; j++) {
                    grid[count[max - k - 1]++][k] = '*';
                    k++;
                 }
            }
    
            for(int i = 0; i < unsorted.length; i++) {
                int k = 0;
                for(int j = 0; j < max && grid[unsorted.length - 1 - i][j] == '*'; j++) {
                    k++;
                }
                sorted[i] = k;
            }
            return sorted;
        }
    public static Scanner sc= new Scanner(System.in);
    public static void main(String ar[]){
       // Scanner sc= new Scanner(System.in);
        System.out.println("Enter no. of element to be inserted in the array:");
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        arr=sort(arr);


        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }
    }
}