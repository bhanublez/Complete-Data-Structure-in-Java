import java.util.Scanner;

public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println("Enter size of Array ");
        int sumOfArray=0;
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter value of Arrays");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sumOfArray+=arr[i];
        }
        int flag=0,dup=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    flag=1;
                    dup=arr[i];
                    break;
                }
            }
        }
        if(flag!=0){
            System.out.println("Duplicate Element is :"+ dup);
        }else{
            System.out.println("No duplicate element exist");
        }
    }
}
