import java.util.Scanner;

public class randomizedQuickSort {
       public static void Quicksort(int[] a, int n) 
            {
                sort(a,0,n-1);
            }
            
            private static void sort(int a[],int low,int up)
            {
                if(low>=up) 
                    return;
                int p = partition(a,low,up);
                sort(a,low,p-1); 
                sort(a,p+1,up); 
            }
       
        private static int partition(int[] a, int low, int up)
	{
		int temp,i,j,pivot;
		int randomIndex=low+(int)Math.random()%(up-low+1);
        pivot=a[randomIndex];
        temp=a[randomIndex];
        a[randomIndex]=a[low];
        a[low]=temp;
        
		i=low+1; 
		j=up;    
		
		while(i<=j)  
		{
			while( a[i]<pivot && i<up ) 
	   			i++; 
			
			while( a[j] > pivot ) 	
				j--;
			
			if(i<j) 
			{
				temp=a[i];	
				a[i]=a[j];	
				a[j]=temp;
				i++; 
				j--;
			}
			else 
				break;
		}
       
		a[low]=a[j];
		a[j]=pivot;

        // System.out.println("Check:");
        // for(int r=0;r<8;r++){
        //     System.out.print(" "+a[r]);
        // }

        // System.out.println();
		
		return j;
	}

    public static void main(String arg[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter no. of element to be inserted in the array:");
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        Quicksort(arr,n);
        System.out.println("Sorted array as:");

        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }
        sc.close();

    }
}
