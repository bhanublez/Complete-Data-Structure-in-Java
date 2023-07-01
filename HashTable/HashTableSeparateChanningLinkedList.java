
//Learn from codecamp youtube channel
import java.util.*;


class Entry<K,V>{
    int hash;
    K key;
    V value;
    
public Entry(K key, V value){
    this.key=key;
    this.value=value;
    this.hash=key.hashCode();
}

public boolean equals(Entry <K,V> other){
    if(hash!=other.hash) return false;
    return key.equals(other.key);
}
public String toString(){
    return key+"->"+value;
}
}
public class HashTableSeparateChanningLinkedList<K,V> implements Iterable<K>{
    private static final int D_capacity=3;
    private static final double D_load_factor=0.75;
    private double maxloadFactor;
    private int capacity, threshold,size=0;
    private java.util.LinkedList<Entry<K,V>> [] table;
    public HashTableSeparateChanningLinkedList(){
        this(D_capacity,D_load_factor);
    }
    public HashTableSeparateChanningLinkedList(int capacity){
        this(capacity,D_load_factor);
    }

    //Designated constructor
    public HashTableSeparateChanningLinkedList(int capacity,double maxloadFactor){
        if(capacity<0)
        throw new IllegalArgumentException("Illegal capacity");
        if(maxloadFactor<=0||Double.isNaN(maxloadFactor)||Double.isInfinite(maxloadFactor))
        throw new IllegalArgumentException("Illegal maxLoadFactor");
        this.maxloadFactor=maxloadFactor;
        this.capacity=Math.max(D_capacity,capacity);
        threshold=(int)(this.capacity*maxloadFactor);
        table=new java.util.LinkedList[this.capacity];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    private int normalizeIndex(int keyhash){
        return (keyhash&0x7FFFFFFF)%capacity;
    }
    public void clear(){
        Arrays.fill(table,null);
        size=0;
    }
    public boolean containsKey(K  key){return hashKey(key);}
    
    public boolean hashKey(K key){
        int bucketIndex=normalizeIndex(key.hashCode());
        return bucketSeekEntry(bucketIndex,key)!=null;
    }
    public V put(K key,V value){return insert(key,value);}
    public V add(K key,V value){ return insert(key,value);}
    public V insert(K key,V value){
        if(key == null)
        throw new IllegalArgumentException("Null key");
        Entry<K,V> newEntry= new Entry<>(key,value);
        int bucketIndex=normalizeIndex(newEntry.hash);
        return bucketInsertEntry(bucketIndex,newEntry);
    }
    
    public V get(K key){
        if(key==null) return null;
        int bucketIndex=normalizeIndex(key.hashCode());
        Entry<K,V> entry =bucketSeekEntry(bucketIndex,key);
        if(entry!=null) return entry.value;
        return null;
    }
    
    public V remove(K key){if(key==null) return null;
    int bucketIndex=normalizeIndex(key.hashCode());
    return bucketRemoveEntry(bucketIndex,key);
    }

    private V bucketRemoveEntry(int bucketIndex,K key){
        Entry<K,V> entry=bucketSeekEntry(bucketIndex,key);
        if(entry !=null){
            java.util.LinkedList<Entry<K,V>> links = table[bucketIndex];
            links.remove(entry);
            size--;
            return entry.value;
        }else{
            return null;
        }
    }
    private V bucketInsertEntry(int bucketIndex,Entry<K,V> entry){
        java.util.LinkedList <Entry<K,V>> bucket=table[bucketIndex];
        if(bucket==null)table[bucketIndex]=bucket=new java.util.LinkedList<>();
        Entry<K,V> existentEntry=bucketSeekEntry(bucketIndex,entry.key);
        if(existentEntry==null){
            bucket.add(entry);
            if(++size>threshold) resizeTable();
            return null;
        }else{
            V oldVal=existentEntry.value;
            existentEntry.value=entry.value;
            return oldVal;
        }
    }
        private Entry<K, V> bucketSeekEntry(int bucketIndex,K key){
            if(key==null) return null;
            java.util.LinkedList<Entry<K,V>> bucket=table[bucketIndex];
            if(bucket==null) return null;
            for(Entry<K,V> entry:bucket)
            if(entry.key.equals(key))
            return entry;
            return null;
        }
    

        private void resizeTable(){
            capacity *=2;
            threshold=(int )(capacity*maxloadFactor);
            java.util.LinkedList<Entry<K,V>> [] newTable=new java.util.LinkedList[capacity];
            for(int i=0;i<table.length;i++){
                if(table[i]!=null){
                    for(Entry<K,V> entry:table[i]){
                        int bucketIndex=normalizeIndex(entry.hash);
                        java.util.LinkedList<Entry<K,V>> bucket=newTable[bucketIndex];
                        if(bucket==null) newTable[bucketIndex]=bucket=new java.util.LinkedList<>();
                        bucket.add(entry);
                          }

                         table[i].clear();
                         table[i]=null;
                                 }
                                   }
                         table=newTable;
                                    }
    public List<K> keys(){
        List<K> keys=new ArrayList<>(size());
        for(java.util.LinkedList<Entry<K,V>> bucket:table)
        if(bucket!=null)
        for(Entry<K,V> entry: bucket)
        keys.add(entry.key);
        return keys;
    }

    public  List <V> values(){
        List <V> values=new ArrayList(size());
        for(java.util.LinkedList<Entry<K,V>>bucket:table)
        if(bucket!=null)
        for(Entry<K,V> entry:bucket)
        values.add(entry.value);
        return values;
    }
    public java.util.Iterator<K> iterator(){
        final int elementCount=size();
        return new java.util.Iterator<K>(){
            int bucketIndex=0;
            java.util.Iterator<Entry<K,V>> bucketItr=(table[0]==null)?null:table[0].iterator();
            public boolean hasNext(){
                if(elementCount!=size)
                throw new java.util.ConcurrentModificationException();

                if(bucketItr==null|| !bucketItr.hasNext()){
                    while(++bucketIndex<capacity){
                        if(table[bucketIndex]!=null){
                            java.util.Iterator<Entry<K,V>> nextItr= table[bucketIndex].iterator();
                            if(nextItr.hasNext()){
                                bucketItr=nextItr;
                                break;
                            }
                        }
                    }
                }
                return bucketIndex < capacity;
            }
            public K next(){
                return bucketItr.next().key;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        for(int i=0;i<capacity;i++){
            if(table[i]==null) continue;
            for(Entry<K,V> entry:table[i])
            sb.append(entry+", ");
        }
        sb.append("}");
        return sb.toString();
    }
    public static void main(String arg[]){
        System.out.println("Testing working of Hash Table");
        HashTableSeparateChanningLinkedList pp= new HashTableSeparateChanningLinkedList(12);
        Entry e=new Entry(0,45);
        System.out.println(pp.size());
        System.out.println(pp.isEmpty());
        pp.clear();
        System.out.println(pp.containsKey(4));
        System.out.println(pp.hashKey(4));
        pp.put(4,45);
        pp.put("324",546);
        pp.put("@#",54);
        pp.put(12,45);
        pp.put('a',-456);
        pp.put(-1,12);
        pp.add("ASd",456);
        pp.insert(-200,'a');
        pp.add(15,"fasdasd");
        System.out.println(pp.get(15));
        System.out.println(pp.get(-200));
        System.out.println("Size is "+pp.size());
        pp.remove(-1);
        int arr[]={45,544,45,45};
        System.out.println(pp.toString());
       Iterator it= pp.iterator();
       while(it.hasNext()){
        System.out.print(" "+it.next());
       }System.out.println();
       System.out.println(pp.hashKey(4));
       System.out.println(e.equals(e));
      System.out.println( e.toString());


        
        
    }

               
}