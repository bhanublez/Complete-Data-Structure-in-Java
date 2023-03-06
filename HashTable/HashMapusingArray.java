import java.util.*;
class Entry<K,V>{
    K key;
    V value;
    int hash;
   public Entry(K key,V value){
        this.key=key;
        this.hash=key.hashCode();
        this.value=value;
    }
public String toString(){
    return key+"->"+value;
}
public boolean equals(Entry<K,V> other){
    if(hash!=other.hash) return false;
    return key.equals(other.key);
}
}

public class HashMapusingArray<K,V>{
    private static final int D_capacity=3;
    private static final double D_load_factor=0.75;
    private int size=0,threshold,capacity;
    private double maxloadfactor;
    private ArrayList<LinkedList<Entry<K,V>>> []table;
    public HashMapusingArray(){
        this(D_capacity,D_load_factor);
    }
    public HashMapusingArray(int capacity){
        this(D_capacity,D_load_factor);
    }
    public HashMapusingArray(int capacity,double maxloadfactor){
        if(capacity<0)
        throw new IllegalArgumentException("Illegal Capacity");
        if(maxloadfactor<=0||Double.isNaN(maxloadfactor)||Double.isInfinite(maxloadfactor))
        throw new IllegalArgumentException("Illegal maxloadfactor");
        this.capacity=capacity;
        this.maxloadfactor=maxloadfactor;
        this.threshold=(int)(this.capacity*maxloadfactor);
        table=new ArrayList[this.capacity];
        for(int i=0;i<10;i++){
            table.add(new LinkedList<Entry<K,V>>());
            size=0;
        }
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    private int normalizeIndex(int keyhash){
        return (keyhash&0x7FFFFFF)%capacity;
    }
    public boolean containsKey(K key){
        return hashKey(key);
    }
    public boolean hashKey(K key){
        int bucketIndex=normalizeIndex(key.hashCode());
        return bucketSeekEntry(bucketIndex,key)!=null;
    }
    private Entry<K, V> bucketSeekEntry(int bucketIndex,K key){
        if(key==null) return null;
        LinkedList<Entry<K,V>> bucket=table[bucketIndex];
        if(bucket==null) return null;
        for(Entry<K,V> entry:bucket)
        if(entry.key.equals(key))
        return entry;
        return null;
    }
   
    
    

    public static void main(String arg[]){
        HashMapusingArray ha=new HashMapusingArray(6);
        System.out.println(ha.size());
        System.out.println(ha.isEmpty());
        System.out.println(ha.containsKey(4));


    }

}