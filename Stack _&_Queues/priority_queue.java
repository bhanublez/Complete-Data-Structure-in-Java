import java.util.*;

public class priority_queue<T extends Comparable<T>>{

    //The number of element currently inside the heap
    private int heapSize=0;

    //The internal capacity of the heap
    private int heapCapacity=0;

    //A dynamic list to track the elements inside the heap
    private List<T> heap=null;

    //This map keeps track of the possible indicies at particular
    //node value is found in the heap. Having this mapping lets
    //us have O(log(n)) removals and O(1) element containment check
    //at  the cost of some additional space and minor overhead
    private Map <T, TreeSet<Integer>>map=new HashMap<>();

    //Construct and intially empty priority queue
    public priority_queue(){
        this(1);
    }
    //Construct a priority queue with an intial capacity
    public priority_queue(int ss)
{
    if(ss<=0){
        throw new IllegalArgumentException("Not possible negative size");
    }else{
    heap= new ArrayList<>(ss);
    }
}
    //Construct a priority queue usinf heapify in O(n) time
    public priority_queue(T[] arr){
        heapSize=heapCapacity= arr.length;
        heap=new ArrayList<T>(heapCapacity);

        //Place all element in the heap
        for(int i=0;i<heapSize;i++){
            mapAdd(arr[i],i);
            heap.add(arr[i]);
        }

        //Heapify process,O(n)
        for(int i=Math.max(0,(heapSize/2)-1);i>=0;i--){
            sink(i);
        }
    }

        //Priority queue constructio,O(nlog(n))
        public priority_queue(Collection <T> elems){
            this(elems.size());
            for(T elem:elems)add(elem);
        }

        //Return true or false depending on if the priority queue is empty
        public boolean isEmpty(){
            return heapSize==0;
        }

        //Clears everything inside the heap ,O(n)
        public void clear(){
            for(int  i=0;i<heapCapacity;i++)
                heap.set(i,null);
                heapSize=0;
                map.clear();
            }
        

            //Return the size of the heap
            public int size(){
                return heapSize;
            }

            //Return the value of the element with the lowest 
            //priority in this priority  queue. If the priority 
            //queue is empty null is returned
            public T peek(){
                if(isEmpty()) return null;
                return heap.get(0);
            }

            //Remove the root of the heap,O(log(n))
            public T poll(){
                return removeAt(0);
            }

            //Test if an element to check containment,O(1)
            public boolean contains(T elem){
            if(elem==null) return false;
            return map.containsKey(elem);
            //Linear scan to check containment ,O(n)
            //for(int i=0;i<heapSize;i++)
            //if(heap.get(i).equals(elem))
            //return true;
            //return false;
            }

            //Adds an element to the priority queue, the element 
            //must not be null,O(log(n))
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

            //Test if the value of the node i<=node j
            //This method assumes i & j are valid indicies ,OO(1)
            private boolean less(int i ,int j){
                T node1=heap.get(i);
                T node2=heap.get(j);
                return node1.compareTo(node2)<=0;
            }

            //Bottom up node swim, O(log(n))
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

            //Top down node sink, O(log(n))
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

            //Swaptwo nodes.Assume i and j are valid,O91
            private void swap(int i,int j){
                T i_elem=heap.get(i);
                T j_elem=heap.get(j);

                heap.set(i,j_elem);
                heap.set(j,i_elem);
                mapSwap(i_elem,j_elem,i,j);
            }

            //Remove a particular element in the heap,O(log(n))
            public boolean remove(T element){
                if(element==null) return false;
                //linear removal via search,O(n)
                //for(int i=0;i<heapSize;i++){
                    // if(element.equals(heap.get(i))){
                    //     removeAt(i);
                    //     return true;
                    // }
                    //Logarthmic removal with map,O(log(n))
                    Integer index=mapGet(element);
                    if(index!=null) removeAt(index);
                    return index != null;
                }

                //Removes a node at particular index,O(log(n))
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

                //REcursively checks if this heap is a min heap
                //This method is just for testing purpose to make
                //Sure the heap inbariant is still being maintained 
                //Called this method with k=0 to start at the root
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

                //Add a node value and its index to the map
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

                //Remove the index at a given value ,O(log(n))
                private void mapRemove(T value, int index){
                    TreeSet<Integer> set=map.get(value);
                    set.remove(index);//TreeSets take O(log(n)) removal time
                    if(set.size()==0) map.remove(value);
                }

                //Extract an index position for the given value
                //If a value exists multiple time in the heap the highest
                //index is returned (this has arbitrrily been chosen)
                private Integer mapGet(T value){
                    TreeSet <Integer> set =map.get(value);
                    if(set!=null) return set.last();
                    return null;
                }

                //Exchange the index of two nodes internally within the map
                private void mapSwap(T val1,T val2,int val1Index, int val2Index){
                    Set<Integer> set1=map.get(val1);
                    Set<Integer> set2=map.get(val2);

                    set1.remove(val1Index);
                    set1.remove(val2Index);               
                }

                @Override public String toString(){
                    return heap.toString();
                }


            }
        
        
    
