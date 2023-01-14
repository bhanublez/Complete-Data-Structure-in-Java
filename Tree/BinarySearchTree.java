public class BinarySearchTree<T extends Comparable<T>>{

    //Track the number of nodes  forming and destroying in this Binary Search tree
    private int nodeCount=0;

    //This BST is a rooted tree so we maintain a handle on the root node
    private  Node root=null;

    //This is used to form new node every time it called which is used to store data and as an reference to that postion 
    private class Node{
        T data;
        Node left,right;
        public Node(Node left,Node right,T data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    //Check if this binary tree is empty or not
    public boolean isEmpty(){
        return size()==0;
    }

    //Get the  number of nodes in this binary tree or simply say it size
    public int size(){
        return nodeCount;
    }

    //Add an element to this binary tree . Return true if we successfully perform an insertion
    public boolean add(T element){
        //Check if the Value already exists in this binary tree if it does ignore adding it
        //
        if(contains(element)){
            return false;
        }
        else{
            root = add(root,element);
            nodeCount++;
            return true;
        }
    }

    //Method to add element in the BST
    private Node add(Node node,T element){
        //Base case-> find a leaf node
        if(node==null){
            node=new Node(null,null,element);
        }
        else{
            if(element.compareTo(node.data)<0){
                node.left=add(node.left,element);
            }else{
                node.right=add(node.right,element);
            }
        }
        return node;
    }
    //Removing element form BST
    public boolean remove(T element){
        //Checking either it contain or not in BST
        if(contains(element)){
            root=remove(root,element);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node,T element){
        if(node==null) return null;
        int c_elm=element.compareTo(node.data);

        //Diging in left sub tre is value is lesser else right one
        if(c_elm<0){
            node.left=remove(node.left,element);
        }
        else if(c_elm>0){
            node.right=remove(node.right,element);
        }
        else{
            if(node.left==null){
                Node  rightChild=node.right;
                node.data=null;
                node=null;
                return rightChild;
            }
            else if(node.right==null){
                Node leftChild=node.left; 
                node.data=null;
                node=null;
                
                return leftChild;
            }else{
                Node tmp=digLeft(node.right);
                node.data=tmp.data;
                node.right=remove(node.right,tmp.data);
            }
        }
        return node;
    }

    //Finding leftmost node of tree
    private Node digLeft(Node node){
        Node cur=node;
        while(cur.left!=null){
            cur=cur.left;
        }
        return cur;
    }
public T digLeft(){
    if(root==null){
        return null;
    }
    return digLeft(root).data;
}
    //Method to find rightmost node in BST
    public T digRight(){
        if(root==null){
            return null;
        }
        return digRight(root).data;
    }
    private Node digRight(Node node){
        Node cur=node;
        while(cur.right!=null){
            cur=cur.right;
        }
        return cur;
    }

    //Return true is the element exisits in the tree
    public boolean contains(T element){
        return contains(root,element);
    }

    //Method for finding element in BST
    private boolean contains(Node node,T element){
        //Base case
        if(node==null) return false;
        int cmp=element.compareTo(node.data);

        //Dig into the left subtree because the value we are
        //looking for is greater then the current value
        if(cmp<0){
            return contains(node.left,element);
        }
     else if(cmp>0){
        return contains(node.right,element);
    }
        else {return true;
    }
}

    //Computes the height of hte BST
    public int height(){

        return height(root);
    }

    private int height(Node node){
        if(node==null) return 0;
        return Math.max(height(node.left),height(node.right))+1;

    }
    public enum TreeTraversalOrder{
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }
     public  java.util.Iterator<T> traverse(TreeTraversalOrder order){
        switch(order){
            case PRE_ORDER: return preOrderTraversal();
            case IN_ORDER: return inOrderTraversal();
            case POST_ORDER: return postOrderTraversal();
            case LEVEL_ORDER: return levelOrderTraversal();
            default: return null;
        }
     }


     private java.util.Iterator<T> preOrderTraversal(){
      final int expectedNodeCount=nodeCount;
       final java.util.Stack<Node> stack=new java.util.Stack<>();
       stack.push(root);
       return new java.util.Iterator<T>(){
        Node trav=root;
        @Override public boolean hasNext(){
            if(expectedNodeCount!=nodeCount){
                throw new java.util.ConcurrentModificationException();
            }
            return root!=null && !stack.isEmpty();
        }
        public T next(){
            if(expectedNodeCount!=nodeCount) throw new java.util.ConcurrentModificationException();
            Node node =stack.pop();
            if(node.right!=null){
                stack.push(node.right);
              }
          if(node.left!=null){
           stack.push(node.left);
          }
            return node.data;
        }
       };
    }
    private java.util.Iterator<T>  levelOrderTraversal(){
        final int expectedNodeCount =nodeCount;
       final java.util.Queue<Node> queue=new java.util.LinkedList<>();
       queue.offer(root);
       return new java.util.Iterator<T>(){
        public boolean hasNext(){
            if(expectedNodeCount!=nodeCount){
                 throw new java.util.ConcurrentModificationException();
            }
            return root!=null && !queue.isEmpty();
        }
        public T next(){
            if(expectedNodeCount!=nodeCount){
                throw new java.util.ConcurrentModificationException();                
            }
            Node node=queue.poll();
            if(node.left!=null)
            queue.offer(node.left);
            if(node.right!=null)
            queue.offer(node.right);
            return node.data;
        }
       };

    }
    private java.util.Iterator<T> inOrderTraversal(){
        int expectedNodeCount=nodeCount;
        java.util.Stack<Node> stack=new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>(){
            Node trav=root;
           @Override public boolean hasNext(){
                if(expectedNodeCount !=nodeCount ){
                    throw new java.util.ConcurrentModificationException();
                }
                return root!=null && !stack.isEmpty();
            }
                public T next(){
                    if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();

                    //Dig left
                    while(trav!=null && trav.left!=null){
                        stack.push(trav.left);
                        trav=trav.left;
                    }
                    Node node =stack.pop();
                    if(node.right != null){
                        stack.push(node.right);
                        trav=node.right;
                    }                    
                    return node.data;
                }            
        };
     }
    private java.util.Iterator<T> postOrderTraversal(){
       final int expectedNodeCount=nodeCount;
        final java.util.Stack<Node> stack1=new java.util.Stack<>();
        final java.util.Stack<Node> stack2=new java.util.Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node node=stack1.pop();
            if(node!=null){
                stack2.push(node);
                if(node.left!=null)
                stack1.push(node.left);
                if(node.right!=null)
                stack1.push(node.right);
            }
        }
        return new java.util.Iterator<T>(){
            Node trav=root;
            @Override public boolean hasNext(){
                if(expectedNodeCount !=nodeCount ){
                    throw new java.util.ConcurrentModificationException();
                }
                return root!=null && !stack2.isEmpty();
            }
            public T next(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return stack2.pop().data;
            }
        };
        
     }

  //In linera searching slower way
public void preorder(){
    preorder(root);
    System.out.println();
}
private void preorder(Node node){
    if(node==null) return;
    System.out.print(" "+node.data);
    preorder(node.left);
    preorder(node.right);
}
public void inorder(){
    inorder(root);
    System.out.println();
}
private void inorder(Node node){
    if(node==null) return;
   
    inorder(node.left);
    System.out.print(" "+node.data);
    inorder(node.right);
}
public void postorder(){
    postorder(root);
    System.out.println();
}
private void postorder(Node node){
    if(node==null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.print(" "+node.data);      
}

    public static void main(String ar[]){
        BinarySearchTree BT=new BinarySearchTree();
         System.out.println("Largest Value "+BT.digRight());
        System.out.println("Smallest Value "+BT.digLeft());
        System.out.println("Is the tree is Empty "+BT.isEmpty());
        System.out.println("No of nodes in tree is "+BT.size());
        System.out.println("height of tree is "+BT.height());
        BT.add(20);
        BT.add(10);
        BT.add(25);
        BT.add(5);
        BT.add(15);
        BT.add(1);
        BT.add(7);
        BT.add(6);
        System.out.println("No of nodes in tree is "+BT.size());
        //System.out.println(BT.remove(7));
        System.out.println(BT.contains(20));
        System.out.println("New size "+BT.size());
        System.out.println("Largest Value "+BT.digRight());
        System.out.println("Smallest Value "+BT.digLeft());
        //In linera searching slower way
        BT.preorder();
        BT.postorder();
        BT.inorder();

        //Iterator searching faster way also very useful in seraching purpose
        java.util.Iterator it=BT.traverse(TreeTraversalOrder.IN_ORDER);
        while(it.hasNext()){
            Object element=it.next();
            System.out.print(" "+element);
        }System.out.println();

        it=BT.traverse(TreeTraversalOrder.PRE_ORDER);
        while(it.hasNext()){
            Object element=it.next();
            System.out.print(" "+element);
        }System.out.println();

        it=BT.traverse(TreeTraversalOrder.POST_ORDER);
        while(it.hasNext()){
            Object element=it.next();
            System.out.print(" "+element);
        }System.out.println();

        it=BT.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while(it.hasNext()){
            Object element=it.next();
            System.out.print(" "+element);
        }System.out.println();


     
        
    }
}