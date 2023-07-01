package BackTracking;

import java.util.Scanner;

public class TileProblem {
    public static int Gatway(int n){
        //Base Case
        if(n<=3){
            return n;
        }else{
            return Gatway(n-1)+Gatway(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter n value for solving tile Problem: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("For given dimension No of possible ways for placing tile is: "+Gatway(n));

        
    }
}
