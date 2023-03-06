public class Q_probing_main{
    public static void main(String ar[]){
        HashTableQuadraticProbing hp=new HashTableQuadraticProbing(10);
        System.out.println( hp.size());
        System.out.println(hp.isEmpty());
        hp.clear();
       
        hp.add(165,1);
        System.out.println("helhdflo");
        hp.insert(100,11);
        hp.insert(54,3);
        hp.insert(4,5);
        hp.insert(5646,33);
      
        System.out.println(hp.conatinsKey(4));
    }
}