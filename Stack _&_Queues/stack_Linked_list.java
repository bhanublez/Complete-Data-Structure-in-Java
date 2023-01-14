public class stack_Linked_list<T> implements Iterable<T>{
private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

//Create an Empty satck
public  stack_Linked_list(){}

//Create a Stack with an initial element
public  stack_Linked_list(T firstelem){
    push(firstelem);
}

//Return the number of element in the stack
public int size(){
    return list.size();
}

//Check wether the stack is empty or not
public boolean isEmpty(){
    if(size()==0){
        return true;
    }
    else
    return false;
}

//Push an element on the stack
public void push(T elem){
    list.addLast(elem);
}

//pop an element off the stack
//Throws an error is the stack is wmpty
public T pop(){
    if(isEmpty()){
        throw new java.util.EmptyStackException();
    }
    return list.removeLast();
}

//Peek the top of the stack without removing an element
//Throw an exception if the stack is empty
public T peek(){
    if(isEmpty()){
        throw new java.util.EmptyStackException();
    }
    return list.peekLast();
}

//Allow user to iterate through the stack using an iterator
@Override public java.util.Iterator<T> iterator(){
    return list.iterator();
}
}  