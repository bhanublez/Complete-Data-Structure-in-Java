import java.util.Collection;
import java.util.Scanner;

public class ReverseOfArray {
    public static void main(String[] args) {
        System.out.println("Enter size of Array ");
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter value of Arrays");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n/2;i++){
            int temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-i-1]=temp;
        }
        System.out.println("Reversed array is: ");
        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }
    }
}
