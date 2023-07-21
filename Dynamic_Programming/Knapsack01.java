package Dynamic_Programming;
import java.util.*;
public class Knapsack01 {
    public static int knapSack(int bagSize,int [] Weight,int[] Profit ){
        if(Weight==null || Profit==null || Weight.length != Profit.length || bagSize<0){
                throw new IllegalArgumentException("Invaid Inputs entered");
        }
        final int N=Weight.length;
        int[][] PbW=new int[N+1][bagSize+1];
        for(int i=1;i<=N;i++){ //i used for object 
            int ww = Weight[i - 1], v = Profit[i - 1];

            for(int w=1;w<=bagSize;w++){ //W use for object weights
                PbW[i][w]=PbW[i-1][w];
                if (w >=ww  && PbW[i - 1][w - ww] + v > PbW[i][w]){
                    PbW[i][w] = PbW[i - 1][w - ww] + v;
                }
      
            }
        }
        int sz = bagSize;
        List<Integer> itemsSelected = new ArrayList<>();
        for (int i = N; i > 0; i--) {
            if (PbW[i][sz] != PbW[i - 1][sz]) {
              int itemIndex = i - 1;
              itemsSelected.add(itemIndex);
              sz -= Weight[itemIndex];
            }
          }
          return PbW[N][bagSize];
    }
    public static void main(String[] args) {
        int capacity = 10;
        int[] V = {1, 4, 8, 5};
        int[] W = {3, 3, 5, 6};
        System.out.println(knapSack(capacity, W, V));
    
        capacity = 7;
        V = new int[] {2, 2, 4, 5, 3};
        W = new int[] {3, 1, 3, 4, 2};
        System.out.println(knapSack(capacity, W, V));
         
    }
}
