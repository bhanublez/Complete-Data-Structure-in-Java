import java.util.Arrays;
import java.util.Scanner;

public class RotationOfMatrix {

    public static void rotateMatrix(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;

        //Transpose of matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        //Swaping of colums
        for(int i=0;i<n;i++){
            int li=0;
            int ri=n-1;
            while(li<ri){
                int temp=arr[i][li];
                arr[i][li]=arr[i][ri];
                arr[i][ri]=temp;
                li++;
                ri--;
            }
        }
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
        //Rotate matrix clockwise by 90 degree
        rotateMatrix(arr);
        
        System.out.println("Final Matrix form after rotation is:");
        for(var mat:arr){
            System.out.println(Arrays.toString(mat));
        }
    }
}
