import java.util.*;
public class AVLtree<T extends Comparable> implements Iterable{

    public class Node implements PrintableNode{
        
        public int bf; //Balance factor
        public T value;
        public int height;
        public Node left,right;
        public Node(T value){
            this.value= value;
        }
        public PrintableNode getLeft(){
            return left;
        }
        public PrintableNode getRight(){
            return right;
        }

        public String getText(){
            return value.toString();
        }
    }

    public Node root;
    private int nodeCount=0;
    public int height(){
        if(root==null) return 0;
        return root.height;
    }
    public int size(){
        return nodeCount;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public boolean contains(T value){
        return contains(root,value);        
    }
    public boolean contains(Node node,T value){
        if(node==null) return false;
        int cmp=value.compareTo(node.value);
        if(cmp<0) return contains(node.left,value);
        if(cmp>0) return contains(node.right,value);
        
        return true;
    }
    public boolean insert(T value){
        if(value==null) return false;
        if(!contains(root, value)){
            root=insert(root,value);
            nodeCount++;
            return true;
        }
        return false;
    }

    private Node insert(Node node,T value){
        if(node==null) return new Node(value);
        int cmp=value.compareTo(node.value);
        if(cmp<0){
            node.left=insert(node.left,value);
        }
        if(cmp>0){
            node.right=insert(node.right,value);
        }
        update(node);
        return balance(node);
    }

    private void update(Node node){
         int leftNodeHeight=(node.left==null)?-1 :node.left.height;
         int rightNodeHeight=(node.right==null)?-1:node.right.height;
         node.height=1+Math.max(leftNodeHeight,rightNodeHeight);
         node.bf=rightNodeHeight-leftNodeHeight;
    }

    private Node balance(Node node){
        if(node.bf==-2){
            if(node.left.bf<=0){
                return leftLeftCase(node);
            }else{
                return leftRightCase(node);
            }
        }else if(node.bf==+2){
            if(node.right.bf>=0){
            return rightRightCase(node);
            }else{
                return rightLeftCcase(node);
            }
        }
        return node;
    }
    private Node leftleftCase(Node node){
        return rightRotation(node);
    }
    private Node leftrightCase(Node node){
        node.left=leftRotation(node.left);
        return leftLeftCase(node);
    }
    private Node rigthLeftCase(Node node){
        node.right=rightRotaion(node.right);
        return rightRightCse(node);
    }

    private Node rightRiNode(node node){
        return leftRotation(node);
    }

    private Node leftRotation(Node node){
        Node newParent=node.right;
        node.right=newParent.left;
        newParent.left=node;
        update(node);
        update(newParent);
        return newParent;
    }
    private Node rightRotation(Node node){
        Node newParent=node.left;
        node.left=newParent.right;
        newParent.right=node;
        update(node);
        update(newParent);
        return newParent;
    }

    public boolean remove(T element){
        if(element==null) return false;
        if(contains(root,element)){
        nodeCount--;
        return true;
        }
        return false;
    }
    
    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    

}