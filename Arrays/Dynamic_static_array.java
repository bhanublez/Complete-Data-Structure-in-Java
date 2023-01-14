import java.util.*;
public class Dynamic_static_array <T> implements Iterable <T>{
    private T[] arr;
    private int len=0;
    private int capacity =0;

    //Setting the Size of the Array
    public Dynamic_static_array(){ this(16);}
    
    // Checking and Updating Capacity of the Array
    public Dynamic_static_array(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("Illegal Capacity: "+capacity);
        }
        this.capacity=capacity;
        arr=(T[]) new Object[capacity];
    }
    //Getting the size of the array
    public int size(){
        return len;}
      //Checking wether the array is empty or not  
        public boolean isEmpty(){
            return size()==0;
        }

        //Getting element at that position
        public T get(int index){
            return arr[index];
        }

        //Setting element at specific position
        public void set(int index,T elem){
            arr[index]=elem;
        }

        //Clearing all the element of the array
        public void clear(){
            for(int i=0;i<capacity;i++){
                arr[i]=null;
                len=0;
            }
        }
        //Adding element in the array
            public void add(T elem){
                if(len+1>=capacity){
                    if(capacity==0) capacity=1;
                    else capacity*=2;
                    T[] new_arr=(T[]) new Object[capacity];
                    for(int i=0;i<len;i++){
                        new_arr[i]=arr[i];
                    }
                    arr=new_arr;
                }
                arr[len++]=elem;
            }

            //Removing element at Specific Position
            public T removeAt(int rm_index){
                if(rm_index>=len &&rm_index<0){
                    throw new IndexOutOfBoundsException();
                }
                T data= arr[rm_index];
                T[] new_arr= (T[]) new Object[len-1];
                for(int i=0,j=0;i<len;i++,j++)
                    if(i==rm_index) j--;
                    else new_arr[j]=arr[i];
                    arr=new_arr;
                    capacity=--len;
                    return data;
                }
                //If element found then remove else return false
                public boolean remove(Object obj){
                    for(int i=0;i<len;i++){
                    if(arr[i].equals(obj)){
                        removeAt(i);
                        return true;
                    }
                    }
                    return false;
                }

                //Checking element presence if found than written index else -1
                public int indexOf(Object obj){
                    for(int i=0;i<len;i++)
                        if(arr[i].equals(obj))
                        return i;
                        return -1;
        
                }

                //Checking object contain or not
                public boolean contains(Object obj){
                    return indexOf(obj) !=-1;
                }

                //Iterator is still fast but not as fast as iterative for loop
                @Override public java.util.Iterator <T> iterator(){
                    return new java.util.Iterator<T>(){
                        int index=0;
                        public boolean hasNext(){
                            return index<len;
                        }
                        public T next(){
                            return arr[index++];
                        }
                       };
                }

                //Coverting the provided array in proper string format
                @Override public String toString(){
                    if(len==0)return "||";
                    else{
                        StringBuilder sb= new StringBuilder(len).append("[");
                        for(int i=0;i<len-1;i++)
                        sb.append(arr[i]+", ");
                        return sb.append(arr[len-1]+"]").toString();
                    }
                }  

            }

        
    

