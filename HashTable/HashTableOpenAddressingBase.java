import java.util.*;
class Entry<K,V>{
    K key;
    V value;
    int hash;
    public Entry(K key,V value){
        this.key=key;
        this.value=value;
        this.hash=key.hashCode();
    }
}
public class HashTableOpenAddressingBase implements Iterable{
    private int size=0;
    private static final int Default_capacity=8;
    private static final double Default_loadfactor=0.75;
    private int capacity,threshold;
    private double loadFactor;

    public HashTableOpenAddressingBase(){
        this(Default_capacity,Default_loadfactor);
    }
    public HashTableOpenAddressingBase(int c){
        //this.capacity=c;
        this(c,Default_loadfactor);
    }
    public HashTableOpenAddressingBase(int c,double lf){
        if(capacity<=0) throw new IllegalArgumentException("Illegal capacity "+c);
        if (loadFactor<=0 || Double.isNaN(lf) || Double.isInfinite(lf))
        throw new IllegalArgumentException("Illegal LoadFactor: "+loadFactor);
        this.capacity=c;
        this.loadFactor=lf;
        this.threshold=(int) ((int)capacity*loadFactor);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size()==0; 
    }
    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
