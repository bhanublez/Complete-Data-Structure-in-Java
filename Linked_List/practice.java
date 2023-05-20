public class practice {

    public static int size=0;
    public class Node{
        Node next;
        int data;
        public Node(int data){
            this.next=null;
            this.data=data;
        } 
    }
    public static Node head;
    public static Node tail;

    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    //Insertion at beginning
    public void insertAtBegin(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void insertAtLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        tail=newNode;

    }
    public void insertionAtMiddle(int data,int index){
        
    }
    public static void main(String ar[]){

    }

}
