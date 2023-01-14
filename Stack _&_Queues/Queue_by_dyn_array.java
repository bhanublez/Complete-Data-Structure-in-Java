public class Queue_by_dyn_array<T>{
    private java.util.ArrayList <T> list =new java.util.ArrayList<T> ();
    private static int size;
    public Queue_by_dyn_array(){}
    public Queue_by_dyn_array(T firstElem){
        enque(firstElem);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue Empty");
        }
        return list.get(0);
    }
    public T deque(){
        int r=0;
        if(isEmpty()){
            r=1;
            throw new RuntimeException("Queue Empty");
           
            
        }
        if(r==0){
        size--;}
        return list.remove(0);
    }
    public void enque(T elem){
        size++;
        list.add(elem);
    }
    public static void main(String arg[]){
        System.out.println("Checking working of stack of Array List");
        Queue_by_dyn_array s =new Queue_by_dyn_array();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        s.enque(2);
        s.enque("dzx");
        s.enque('f');
        s.deque();
        System.out.println(" "+s.peek());

    }   

}