import java.util.*;
public class Dynamic_array_check_main_method{
    public static Scanner sc= new Scanner(System.in);

    public static void main(String arg[]){
        Dynamic_static_array dd= new Dynamic_static_array(45);
        System.out.println("Its size is: "+dd.size());
        System.out.println("Is it is Empty: "+dd.isEmpty());
        dd.set(1,99);
        System.out.println("Get its index: "+dd.get(1));
        dd.clear();
        System.out.println("Enter 10 random integers");
        for(int i=0;i<10;i++){
            dd.add(sc.nextInt());
        }
    System.out.println(dd.removeAt(4));
    System.out.println(dd.remove(999));
    System.out.println(dd.indexOf(88));
    System.out.println(dd.contains(45));

    String ss=dd.toString();
    System.out.println(ss);
    }
}