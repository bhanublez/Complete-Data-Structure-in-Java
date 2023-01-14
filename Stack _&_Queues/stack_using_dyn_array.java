public class stack_using_dyn_array<T>{
   
    public stack_using_dyn_array(){}
    private java.util.ArrayList <T> list = new java.util.ArrayList<T>();
    private static int size;
    public stack_using_dyn_array(T element){
        push(element);
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else
        return false;
    }
    public T pop(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        }
        size--;
        return list.remove(size);
    }
    public T peek(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        }
        return list.get(size-1);
    }
    

    public int size(){
        return list.size();
    }
    public void push(T ele){
        size++;
        list.add(ele);
    }
   
    public static void main(String arg[]){
        System.out.println("Checking working of stack of Array List");
        stack_using_dyn_array s =new stack_using_dyn_array();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        s.push(2);
        s.push("dzx");
        s.push('f');
        s.pop();
        System.out.println(" "+s.peek());

    }   

}