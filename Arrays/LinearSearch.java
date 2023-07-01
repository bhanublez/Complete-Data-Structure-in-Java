import java.util.*;
public class LinearSearch {
    public static int getRandom(int[] array) {
        int rnd = (int)(Math.random()*array.length);
        return array[rnd];
    }
    public static void main(String ar[]){
        int arrr[]= new int[10];
        getRandom(arrr);
        int arr[]={1,28,234,324,54};
        System.out.println(Arrays.toString(arr));
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the element to be searched in guiven array");
        int target=sc.nextInt();
        int flag=0,index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                flag=1;
                index=i;
                break;
            }
        }
        if(flag!=1){
            System.out.println("Given target is not found inthe array");
        }else{
            System.out.println("Target "+target+" is founded at index: "+index);
        }
    }
}
