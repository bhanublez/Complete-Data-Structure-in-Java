public class CircularLinkedList{
    public static Node tail;
    public static int size;
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=tail;
        }
    }
    public void insertionAtTail(int data){
        Node newNode= new Node(data);
        size++;
        if(tail==null){
            tail=newNode;
            newNode.next=tail;
            return;
        }
        Node temp=tail;
        while(temp.next!=tail){
            temp=temp.next;
        }
        newNode.next=tail;
        temp.next=newNode;
        
       
        
    }
    public void insertionAtMiddle(int data,int index){
        int i=0;
        Node newNode= new Node(data);
        size++;
       
        if(tail==null){
            tail=newNode;
            newNode.next=tail;
            return;
        }
        int f=0;
        if(index==0){
            f=1;
           index=size-1;
        }
        Node temp=tail;
       
        while(i<index-1){
            i++;
            temp=temp.next;
        }

        newNode.next=temp.next;
        temp.next=newNode;
        if(f==1){
            tail=newNode;
        }
       
    }
    public void display(){
        Node temp=tail;
        if(tail==null){
            System.out.println("Circular Linked list is empty");
            return;
        }
        System.out.print(" "+temp.data);        
        while(temp.next!=tail){
            temp=temp.next;
            System.out.print(" "+temp.data);
            
        }
        System.out.println();
    }
    public void deletionAtBegin(){
       if(size==0){
        System.out.println("Circular Linked list is already empty");
        return;
       }
        if(size==1){
            tail=null;
            size=0;
            return;
        }
        Node temp=tail;
        size--;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=tail.next;
        tail=tail.next;
    }
    public void deletionAtLast(){
        if(size==0){
            System.out.println("Circular Linked list is already empty");
            return;
           }
        if(size==1){
            tail=null;
            size=0;
            return;
        }
        Node temp=tail;
        size--;
        while(temp.next.next!=tail){
            temp=temp.next;

        }
        temp.next=tail;
       

    }
    public void deletionAtMiddle(int index){
        if(size==0){
            System.out.println("Circular Linked list is already empty");
            return;
           }
        if(size==1){
            tail=null;
            size=0;
            return;
        }
        if(index==0){
            deletionAtBegin();
            return;
        }
        if(index==size-1){
            deletionAtLast();
            return;
        }
        Node temp=tail;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        size--;

    }
    public void SearchList(int data){
        if(size==0){
            System.out.println("Circular Linked list is already empty");
            return;
           }
           Node temp=tail;
           int f=0;
           while(temp.next!=tail){
            if(temp.data==data){
                f=1;
                
            }
            temp=temp.next;
           }
           if(f==1){
           System.out.println("Element is founded");
           }
           else{
            System.out.println("Element is not founded");
           }

    }

    public static void main(String arf[]){
        CircularLinkedList cc= new CircularLinkedList();
        cc.display();
        cc.insertionAtTail(45);
        cc.display();
        cc.insertionAtTail(75);
        cc.insertionAtTail(99);
        cc.display();
        cc.insertionAtMiddle(995,0);
        cc.insertionAtMiddle(2,4);
        cc.insertionAtMiddle(5,0);
        cc.display();
       
        cc.deletionAtBegin();
        cc.display();
        cc.deletionAtLast();
        cc.display();
        cc.deletionAtMiddle(3);
        System.out.println("size is: "+size);
        cc.display();
        cc.SearchList(995);

        

    }

} 