import java.util.Arrays;

public class MergeSort {

    public static int[] mergesort(int[] ar){
        int n=ar.length;

        //Base case 
        if(n<=1){
            return ar;
        } 

        //Spliting or say dividing array
        int[] left = mergesort(Arrays.copyOfRange(ar, 0, n / 2));
        int[] right = mergesort(Arrays.copyOfRange(ar, n / 2, n));

        return merge(left,right);
    }
    private static int[] merge(int[] left,int[]  right){
       // System.out.println("Reached");
        int n1=left.length;
        int n2=right.length;
        int n=n1+n2,i1=0,i2=0;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            if(i2==n2){
                arr[i]=left[i1];
                i1++;
            }else if(i1==n1){
                arr[i]=right[i2];
                i2++;
            }else {      
            if(left[i1]<right[i2]){
                arr[i]=left[i1++];
            }else{
                arr[i]=right[i2];
                i2++;
            }
        }
    }
        
          

        return arr;
    }
    public static void main(String[] args) {
        int [] array={21,3,2,34,1,4,-1,24,0};
        array=MergeSort.mergesort(array);
        System.out.println(Arrays.toString(array));
    }
}
