import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter size of arrya");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Enter array elemnet");
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
    int flag=0;
    for(int i=0;i<n/2;i++){
        if(arr[i]!=arr[n-1-i]){
            flag=1;
            break;
        }
        
    }
    if(flag==1){
        System.out.println("Array is not Palindromic");
    }else{
        System.out.println("Array is Palindromic");
    }
    //Space Complexity O(1)
    //Time Complexity O(n)

    }
}
