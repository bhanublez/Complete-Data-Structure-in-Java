import java.util.*;

public class Prefix_Sum {
    public static void prefixSumMatric(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        //row wise prefix sum
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                    arr[i][j]+=arr[i][j-1];
            }
        }

        //columns wise prefix sum
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                arr[i][j]+=arr[i-1][j];
            }
        }

    }
    public static int regionSum(int arr[][],int r1,int c1,int r2,int c2){
        int sum=0,up=0,left=0,repeate_region=0;
        sum=arr[r2][c2];
        up=arr[r1-1][c2];
        left=arr[r2][c1-1];
        repeate_region=arr[r1-1][c1-1];

        return sum-up-left+repeate_region;
    }
    public static void main(String[] args) {
        System.out.println("Enter number of rows and Colums");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]= new int[n][n];
        System.out.println("Enter element of matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Matrix form is: ");
        for(var mat:arr){
            System.out.println(Arrays.toString(mat));
        }
       System.out.println("Enter the Coordinates First: ");
       int r1=sc.nextInt();
       int c1=sc.nextInt();
       System.out.println("Enter the coordinate Second");
       int r2=sc.nextInt();
       int c2=sc.nextInt();
        int sum=0;
        //Brute force approach 1
    //    for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //             if(i>=r1 && i<=r2 && j<=c2 && j>=c1){
    //                 sum+=arr[i][j];
    //             }
    //     }
    //    }
        //Aproach 2
        // for(int i=r1;i<=r2;i++){
        //     for(int j=c1;j<=c2;j++){
        //         sum+=arr[i][j];
        //     }
        // }
        prefixSumMatric(arr);
         System.out.println(arr[r2][c1-1]);
        System.out.println(arr[r1-1][c1-1]);
       sum=regionSum(arr,r1,c1,r2,c2);
       System.out.println("Sum is: "+sum);
    }
}
