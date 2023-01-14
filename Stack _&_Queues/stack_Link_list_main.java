import java.util.*;

public class stack_Link_list_main{
public static Scanner sc= new Scanner(System.in);
    public static void main(String arh[]){
        stack_Linked_list ss= new stack_Linked_list();
        System.out.println(ss.isEmpty());
        System.out.println(" "+ss.size());
        ss.push(1);
        ss.push(2);
        ss.push(3);

        System.out.println(" "+ss.peek());
        ss.pop();
        System.out.println(" "+ss.peek());
        
        

    }
}