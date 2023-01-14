import java.util.*;

public class  Queue_LL_main{
    public static void main(String arf[]){
        Queue_LinkedList q = new Queue_LinkedList();
        System.out.println("Checking the working of Queue");
        System.out.println(" "+q.isEmpty());
        q.offer(45);
        q.offer('s');
        q.offer("ASDas");
        q.poll();
        System.out.println(" "+q.peek());
        System.out.println(" "+q.size());
        
    }

}