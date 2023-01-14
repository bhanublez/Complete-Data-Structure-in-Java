import java.util.ArrayList;
class ArrayListManagement{

    public static void main(String arr[]){
        ArrayList<String> a= new ArrayList<String>();
        String a1 = new String("one");
        a.add(a1);
        String a2= new String("two");
        a.add(a2);
        String a3= new String("three");
        a.add(a3);
        printAL(a);
        if(a.contains("two")){
            a.add("Four");
        }
        printAL(a);
        a.remove("two");
        if(a.indexOf("Four")!=4){
            a.add("Five");
        }
        printAL(a);
    }
    public static void printAL(ArrayList<String> aa){
        for(String element: aa){
            System.out.print(element+" ");
        }
        System.out.println("");
    }
}