package Practice_Hasing;
import java.util.*;
class Entry<K,V>{
    int hash;
    K key;
    V value;
    public Entry(K key,V vale){
        this.key=key;
        this.value=value;
        this.hash=key.hashCode();
    }

    public boolean equals(Entry<K,V> other){
        if(hash!=other.hash){
            return false;
        }
        return key.equals(other.key);
    }

    public String toString(){
        return this.key+"->"+this.value;
    }
}
public class htscLL<K,V> implements Iterable<K> {
    private  static final int DC=8;
    private final static double DLF=0.75;
    private int size=0;
    private int c;
    private double lf;
    private int th;
    private LinkedList<Entry<K,V>> []table;
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public htscLL(){
        this(DC, DLF);
    }
    public htscLL(int c){
        this(c, DLF);
    }
    public htscLL(int c,double lf){
        this.c=c;
        this.lf=lf;
        th=(int) ((int)c*lf);
    }
    public int normalizeIndex(int keyhash){
        return (keyhash&0x7FFFFFFF)%c;
    }
    public void clear(){
        Arrays.fill(table,null);
        size=0;
    }
    public boolean hashKey(K key){
        int bucketIndex =normalizeIndex(key.hashCode());
        return bucketSeekEntry(bucketIndex,key)!=null;
    }
    private Entry<K,V> bucketSeekEntry(int bucketIndex,K key){
        if(key==null) return null;
        LinkedList<Entry<K,V>> bucket=table[bucketIndex];
        if(bucket==null) return null;
        for(Entry<K,V> entry:bucket){
            if(entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }
    private V bucketInsertEntry(int bukindex,Entry<K,V> entry){
        LinkedList<Entry<K,V>> bucket=table[bukindex];
        if(bucket==null) table[bukindex]=bucket=new LinkedList<>();
        Entry<K,V> exitEtry=bucketSeekEntry(bukindex,entry.key);
        if(exitEtry==null){
            bucket.add(entry);
            if(++size>th) resizeTable();

            return null;
        }else{
            V oldV=exitEtry.value;
            exitEtry.value=entry.value;
            return oldV;
        }

    }
    private void resizeTable(){
        c*=2;
        th=(int)(c*lf);
        LinkedList<Entry<K,V>> [] newTable=new LinkedList[c];
        for(int i=0;i<table.length;i++){
            if(table[i]!=null){
                for(Entry<K,V> entry:table[i]){
                    int bukindex=normalizeIndex(entry.hash);
                    LinkedList<Entry<K,V>> bucket=newTable[bukindex];
                    if(bucket==null) newTable[bukindex]=bucket=new LinkedList<>();
                    bucket.add(entry);
                }
                table[i].clear();
                table[i]=null;

            }
        }
        table=newTable;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    public static void main(String arg[]){
        System.out.println("Testing working of Hash Table");
        htscLL pp= new htscLL(12);
        Entry e=new Entry(0,45);
        System.out.println(pp.size());
        System.out.println(pp.isEmpty());
        pp.clear();
        //System.out.println(pp.containsKey(4));
        System.out.println(pp.hashKey(4));
        // pp.put(4,45);
        // pp.put("324",546);
        // pp.put("@#",54);
        // pp.put(12,45);
        // pp.put('a',-456);
        // pp.put(-1,12);
        // pp.add("ASd",456);
        // pp.insert(-200,'a');
        // pp.add(15,"fasdasd");
        // System.out.println(pp.get(15));
        // System.out.println(pp.get(-200));
        // System.out.println("Size is "+pp.size());
        //pp.remove(-1);
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
