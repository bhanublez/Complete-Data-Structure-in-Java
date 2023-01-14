import java.util.*;

public class prac<T extends Comparable<T>>{
    private static int heapSize;
    private static int heapCapacity;
    private ArrayList<T> heap=null;
    private Map<T,TreeSet<Integer>> map= new HashMap<>();
    public prac(){
        this(1);
    }
    public prac(int ss)
    {
        if(ss<=0){
            throw new IllegalArgumentException("Not possible negative size");
        }
        else{
        heap= new ArrayList<>(ss);
        }
    }
    
    public boolean isEmpty(){
        return heapSize==0;
    }
    public int size(){
        return heapSize;
    }
    public T peek(){
        if(isEmpty()) return null;
        return heap.get(0);
    }

    public prac(T[] arr){
        heapSize=heapCapacity=arr.length;
        heap= new ArrayList<T>(heapCapacity);

        for(int i=0;i<heapSize;i++){
            mapAdd(arr[i],i);
            heap.add(arr[i]);
        }
        for(int i=Math.max(0,(heapSize/2)-1);i>=0;i--){
            sink(i);
        }


    }
    public void clear(){
        for(int  i=0;i<heapCapacity;i++)
            heap.set(i,null);
            heapSize=0;
            map.clear();
        }
        public T poll(){
            return removeAt(0);
        }
        public boolean contains(T elem){
            if(elem==null) return false;
            return map.containsKey(elem);
            //Linear scan to check containment ,O(n)
            //for(int i=0;i<heapSize;i++)
            //if(heap.get(i).equals(elem))
            //return true;
            //return false;
            }
            
    private boolean less(int i ,int j){
        T node1=heap.get(i);
        T node2=heap.get(j);
        return node1.compareTo(node2)<=0;
    }
    private void swap(int i,int j){
        T i_elem=heap.get(i);
        T j_elem=heap.get(j);

        heap.set(i,j_elem);
        heap.set(j,i_elem);
        mapSwap(i_elem,j_elem,i,j);
    }
    private void mapSwap(T val1,T val2,int val1Index, int val2Index){
        Set<Integer> set1=map.get(val1);
        Set<Integer> set2=map.get(val2);

        set1.remove(val1Index);
        set1.remove(val2Index);               
    }
 

    private Integer mapGet(T value){
        TreeSet <Integer> set =map.get(value);
        if(set!=null) return set.last();
        return null;
    }
    public boolean remove(T element){
        if(element==null) return false;
        //linear removal via search,O(n)
        for(int i=0;i<heapSize;i++)
            if(element.equals(heap.get(i))){
                removeAt(i);
                return true;
            }

            return false;
            //Logarthmic removal with map,O(log(n))
        //    Integer index=mapGet(element);
        //     if(index!=null) removeAt(index);
        //     return index != null; 
        
    }
        private void swim(int k){

            //Grap the index of the next parents node WRT to k
            int parent = (k-1)/2;

            //Keep swimming while we have not reached the root
            //and whiel we are less than our parent
            while(k>0&& less(k,parent)){
                //Exchange k with the parent
                swap(parent, k);
                k=parent;
                
                //Grap th index of the next parent node WRT to k
                parent=(k-1)/2;
            }
        }
        public boolean isMinHeap(int k){
            //If we are outside the bounds of the heapreturn true
            if(k>=heapSize) return true;
            int left=2*k+1;
            int right=2*k+2;

            //Make sure that the current node k is less than bothh
            //of its childrean left and right if they exist
            //return false otherwise to indicate an invalid heap
            if((left<heapSize && !less(k,left))) return false;
            if((right<heapSize && !less(k,right))) return false;
            
            //Recurse on both children to make sure they are also valid heaps
            return isMinHeap(left) && isMinHeap(right);    
        } 
        private void mapRemove(T value, int index){
            TreeSet<Integer> set=map.get(value);
            set.remove(index);//TreeSets take O(log(n)) removal time
            if(set.size()==0) map.remove(value);
        }
        
        private T removeAt(int i){
            if(isEmpty()){
                return null;
            }

            heapSize--;
            T removed_data=heap.get(i);
            swap(i,heapSize);

            //obliterate the value
            heap.set(heapSize,null);
            mapRemove(removed_data,heapSize);

            //Remove last element
            if(i==heapSize) return removed_data;

            T elem= heap.get(i);

            //Try sinking element
            sink(i);

            //If sinking did not work try swimming
            if(heap.get(i).equals(elem))
            swim(i);
            return removed_data;
        }
    private void sink(int k){
        while(true){
            int left=2*k+1;//Left node
            int right=2*k+2;//Right node
            int smallest=left;//Assume lest id the smallestnode of the two childrean
            
            //Find which is smaller left or right
            //If right is smaller set smallest ti be right 
            if(right<heapSize&& less(right,left))
            smallest=right;

            //Stop if we are outside the bound of the tree
            //or stop early f we cannot sink kanymore
            if(left>=heapSize||less(k,smallest)) break;

            //Movedown the tree following the smallest node
            swap(smallest,k);
            k=smallest;
        }
    }

    private void mapAdd(T value,int index){
        TreeSet <Integer> set= map.get(value);

        //New value being inserted in map
        if(set==null){
            set= new TreeSet<>();
            set.add(index);
            map.put(value,set);

            //Value already exists in map
        }else set.add(index);

    }

   // private void
   public void add(T elem){
    if(elem==null) throw new IllegalArgumentException();

    if(heapSize<heapCapacity){
        heap.set(heapSize,elem);
    }else{
        heap.add(elem);
        heapCapacity++;
    }
    mapAdd(elem,heapSize);
    swim(heapSize);
    heapSize++;
}

    public static void main(String ar[]){
        System.out.println("Checking working of priority Queue");
        int arr[]={1,2,3,4,5};
        prac p= new prac(5);
        System.out.println(" "+p.isEmpty());
        System.out.println(" "+p.size());
        p.clear();
        
        p.add(2);
        p.add(1);
        p.add(45);
        p.add(24);
        p.add(11);
        p.add(445);
        p.add(2);
        p.add(1);
        p.add(45);
        p.add(24);
        p.add(11);
        p.add(445);
        System.out.println(p.peek());
        System.out.println(p.poll());
        System.out.println(p.contains(2));
       System.out.println( p.remove(2));
       System.out.println(" "+p.size());
      System.out.println(  p.isMinHeap(4));


      
    }
}