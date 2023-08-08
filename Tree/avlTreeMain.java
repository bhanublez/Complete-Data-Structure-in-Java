public class avlTreeMain {
    public static void main(String[] args) {
        System.out.println("Hello World");
        AVLtree avl=new AVLtree<>();
        System.out.println("10 "+avl.insert(10));
        System.out.println("10 "+avl.insert(10));
        System.out.println("100 "+ avl.insert(100));
        System.out.println("20 "+avl.insert(20));
        System.out.println("10 removed "+avl.remove(10));
        System.out.println("removed 10 "+avl.remove(10));
        avl.insert(34);
        avl.insert(22);
        avl.insert(94);
        avl.insert(8);
        avl.insert(32);
        avl.insert(27);
        //Iteration value of tree using iterator
        java.util.Iterator<Integer> it=avl.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        

        
    }
}
