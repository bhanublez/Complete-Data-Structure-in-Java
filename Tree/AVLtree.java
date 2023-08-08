import java.util.*;

import org.w3c.dom.Node;
public class AVLtree<T extends Comparable<T>> implements Iterable<T>{
    public class Node{
        int bf;
        Node left,right;
        T value;
        int height;
        public  Node(T value){
            this.value=value;
        }
    }
    private Node root;
    private int countNode=0;

    //Size of AVLTree
    public int size(){
        return countNode;
    }

    //Chech is Empty
    public boolean isEmpty(){
        return countNode==0;
    }

    //Instead of again and again instializing null we can create token
    private Node TOKEN=new Node(null);
     

    //Height of AVLTree
    public int height(){
        if(root==TOKEN){
            return 0;
        }
        return root.height;
    }

    //Checking existing of Value in Tree
    public boolean contains(T value){
        Node node=root;
        while(node!=null){
            int cmp=value.compareTo(node.value);
            if(cmp<0) node=node.left;
            else if(cmp>0) node=node.right;
            else return true;
        }
        return false;
    }

    //Inserting value in AVL tree
    public boolean insert(T value){
        if(value==null) return false;
        Node newRoot=insert(root,value);
        //In case no value is added then
        boolean insertedNode =(newRoot!=TOKEN);
        if(insertedNode){
            countNode++;
            root=newRoot;
        }
        return insertedNode;
    }

    public Node insert(Node node,T value){
        if(node==null) return new Node(value);

        int cmp=value.compareTo(node.value);
        if(cmp<0){
            Node newLeftNode=insert(node.left, value);
            //In case null Node passed here
            if(newLeftNode==TOKEN) return TOKEN;
            node.left=newLeftNode;
        }else if(cmp>0){
            Node newRightNode=insert(node.right,value);
            if(newRightNode==TOKEN){
                return TOKEN;
            }
            node.right=newRightNode;
        }else return TOKEN;

        update(node);
        return balance(node);
    }

    //Udate node blance factor and height
    public void update(Node node){
        int leftNodeHeight=-1;
        if(node.left!=null){
            leftNodeHeight=node.left.height;
        }
        int rightNodeHeight=-1;
        if(node.right!=null){
            rightNodeHeight=node.right.height;
        }

        node.height=1+Math.max(leftNodeHeight,rightNodeHeight);
        node.bf=rightNodeHeight-leftNodeHeight;//Subtraction can be node in both direction
    }

    //Balancing Tree with tree Rotation
    private Node balance(Node node){
        if(node.bf==-2){
            if(node.left.bf<=0){
                return leftLeftCase(node);
            }else{
                return leftRightCase(node);
            }
        }else if(node.bf == +2){
            if(node.right.bf>=0){
                return rightRightCase(node);
            }else{
                return rightLeftCase(node);
            }
        }
        return node;
    }

    private Node leftLeftCase(Node node) {
        return rightRotation(node);
      }
    
      private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
      }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
      }
    
      private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
      }
    
    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        update(node);
        update(newParent);
        return newParent;
      }

    private Node rightRotation(Node node) {
    Node newParent = node.left;
    node.left = newParent.right;
    newParent.right = node;
    update(node);
    update(newParent);
    return newParent; 
  }

    //Remove a value from AVL tree
    public boolean remove(T elem){
        Node newRoot=remove(root,elem);
        boolean removedNode=(newRoot!=TOKEN) || (newRoot==null);
        if(removedNode){
            root=newRoot;
            countNode--;
            return true;
        }
        return false;
    }

    private Node remove(Node node,T value){
        if(node==null) return TOKEN;
        int cmp=value.compareTo(node.value);
        //Smaller
        if(cmp<0){
            Node newLeftNode=remove(node.left,value);
            if(newLeftNode==TOKEN) return TOKEN;
            node.left=newLeftNode;
        }
        //Bigger
        else if(cmp>0){
            Node newRightNode=remove(node.right, value);
            if(newRightNode==TOKEN) return TOKEN;
            node.right=newRightNode;
        }
        //Equal 
        else{
            if(node.left==null){
                return node.right;
            }else if(node.right==null){
                return node.left;
            }else{
                //Done
                if(node.left.height>node.right.height){
                    T replacer=findMax(node.left);
                    node.value=replacer;
                    Node replaced=remove(node.left,replacer);
                    if(replaced==TOKEN) return TOKEN;
                    node.left=replaced;
                }else{
                    T replacer=findMin(node.right);
                    node.value=replacer;
                    Node replaced=remove(node.right,replacer);
                    if(replaced==TOKEN) return TOKEN;
                    node.right=replaced;
                }
            }
        }
        update(node);
        return balance(node);
    }
    
    //LeftMost Minimum in right Node
    private T findMin(Node node){
        while(node.left!=null) node=node.left;
        return node.value;
    }

    //RightMost Maximum in left Node
    private T findMax(Node node){
        while(node.right!=null) node=node.right;
        return node.value;
    }

    //Return as iterator to traverse the tree in order
    public java.util.Iterator<T> iterator(){
        final int expectedCount=countNode;
        final java.util.Stack<Node> stack=new java.util.Stack<>();
        stack.push(root);
        return new java.util.Iterator<T>(){
            Node trav=root;
            public boolean hasNext(){
                if(expectedCount!=countNode) throw new java.util.ConcurrentModificationException();
                return root!=null && !stack.isEmpty();
            }
            public T next(){
                if(expectedCount!=countNode) throw new java.util.ConcurrentModificationException();
                while(trav!=null && trav.left!=null){
                    stack.push(trav.left);
                    trav=trav.left;
                }
                Node node=stack.pop();
                if(node.right!=null){
                    stack.push(node.right);
                    trav=node.right;
                }
                return node.value;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    
    
}