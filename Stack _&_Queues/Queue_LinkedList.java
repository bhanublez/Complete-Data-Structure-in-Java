public class Queue_LinkedList <T> implements Iterable <T>{
    private java.util.LinkedList<T> list= new java.util.LinkedList <T> ();
    public Queue_LinkedList(){

    }
    public Queue_LinkedList(T firstElem){
        offer(firstElem);
    }

    //Return the size of the queue
     public int size(){
        return list.size();
     }

    //Return whether the queue is empty or not
    public boolean isEmpty(){
        return size()==0;
    }

    //Peek the element at the front of the queue 
    //method throws an error if the queue is empty
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue Empty");
        }
        return list.peekFirst();
    }

    //Poll an elemet from the front of the queue
    //The method throws an error if the queue is empty
    public T poll(){
        if(isEmpty()){
            throw new RuntimeException("Queue Empty");
        }
        return list.removeFirst();
    }

    //Add an element to the back of the queue
    public void offer(T elem){
        list.addLast(elem);
    }

    //Return an iterator to allow the user to traverse
    //through the element found inside th queue
    @Override public java.util.Iterator<T> iterator(){
        return list.iterator();
    }
    }

