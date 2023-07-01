import java.util.*;
public class hashTable_Quadratic_Probing <K,V> implements Iterable <K> {
    private double loadFactor;
    protected static int threshold, capacity,modificationCount=0;
    private int usedBuckets=0,keyCount=0;
    private K keyTable[];
    private V valueTable[];
    private boolean containsFlag=false;
    private final K TOMBSTONE= (K) (new Object());
    private static final int DEFAULT_CAPACITY=8;
    private static final double DEFAULT_LOAD_FACTOR=0.45;
    public hashTable_Quadratic_Probing(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }
    public hashTable_Quadratic_Probing(int capacity){
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public hashTable_Quadratic_Probing(int capacity,double loadFactor){
        if(capacity<=0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        if(loadFactor<=0|| Double.isNaN(loadFactor) || Double.isInfinite(loadFactor))
        throw new IllegalArgumentException("Illegal LoadFactor: "+loadFactor);
        this.loadFactor=loadFactor;
        this.capacity=(int) Math.max(DEFAULT_CAPACITY,next2Power(capacity));
        threshold= (int)(this.capacity*loadFactor);
        keyTable=(K[]) new Objects[this.capacity];
        valueTable=(V[]) new Objects[this.capacity];
    }
    private static int next2Power(int n){
        return Integer.highestOneBit(n)<<1;
    }

    private static int P(int x){
        return (x*x +x)>>1;
    }

    private static int normalizeIndex(int keyhash){
        return (keyhash & 0x7FFFFFFF) % capacity;
    }


    

    @Override
    public Iterator<K> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    public static void main(String[] args) {
        System.out.println(("Hello"));
    }
}
