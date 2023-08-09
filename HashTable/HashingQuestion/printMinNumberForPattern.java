//https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1
import java.util.*;
public class printMinNumberForPattern{
     static String printMinNumberForPattern(String str){
        String result="";
       Stack<Integer> stack=new Stack<>();
       for(int i=0;i<=str.length();i++){
           stack.push(i+1);
           if(i==str.length()|| str.charAt(i)=='I'){
               while(!stack.isEmpty()){
                   result+=stack.pop();
               }
           }
       }
       return result;
       
    }

    public static void main(String[] args) {
        printMinNumberForPattern obj=new printMinNumberForPattern();
        String str="IDID";
        System.out.println(obj.printMinNumberForPattern(str));
    }

}