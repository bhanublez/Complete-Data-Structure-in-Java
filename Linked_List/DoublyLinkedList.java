import java.util.*;

public class DoublyLinkedList{
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static int size;
    
    //Method for insertion
    public synchronized void insertAtBegin(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public synchronized void insertAtLast(int data){
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;

    }
    public synchronized void insertionAtMiddle(int data,int index){
        int i=0;
        Node newNode= new Node(data);
        if(index==0){
            insertAtBegin(data);
            return;
        }
        size++;
        if(head==null){
            head=newNode;
            return;
        }
       
        Node temp=head;
        while(i<(index-1)){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next.prev=newNode;
        temp.next=newNode;
        newNode.prev=temp;
       

    }

    //Method for deletion of element in doubly linked list
    public void deletionAtBegin(){
        if(head==null){
            System.out.println("Doubly Linked list is already empty");
            return ;
        }
        if(size==1){
            head=null;
            head.next=null;
            head.prev=null;
            size=0;
            return;
        }
        head=head.next;
        head.prev=null;
        size--;

    }
    public void deletionAtLast(){
        if(head==null){
            System.out.println("Doubly Linked list is already empty");
            return ;
        }
        if(size==1){
            head=null;
            head.next=null;
            head.prev=null;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
        size--;
        


    }
    public void deletionAtMiddle(int index){
        if(head==null){
            System.out.println("Doubly Linked list is already empty");
            return ;
        }
        if(index==0){
           deletionAtBegin();
           return;
        }

        if(index==(size-1)){
            deletionAtLast();
            return;
        }
        size--;
        int i=0;
        Node temp=head;
        while(i<index-1){
            i++;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        temp.next.prev=temp;

    }
    public void SearchList(int data){
        Node temp=head;
        if(head==null){
            System.out.println("Doubly Linked list have no data.");
            return;
        }
        int f=0;
        int i=0;
        while(temp.next!=null){
            temp=temp.next;
            i++;
            if(temp.data==data){
                f=1;
            }
        }
        if(f==0){
            System.out.println("Doubly Linked List dosn't contain data "+data);
        }else{
            System.out.println("Doubly Linked List contains data "+data+" at index "+i);
        }
    }

    public void display(){
        if(head==null){
            System.out.println("Doubly linked list is empty. ");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp=temp.next;
        }System.out.println();
    }

    public static void main(String arg[]){
        DoublyLinkedList d= new DoublyLinkedList();
        d.display();
        d.insertAtBegin(4);
        d.insertAtBegin(5);
        d.display();
        d.insertAtLast(99);
        d.insertAtLast(44);
        d.display();
        d.insertionAtMiddle(78,2);
        d.display();
        d.deletionAtBegin();
        d.display();
        d.deletionAtLast();
        d.display();
        d.deletionAtMiddle(2);
        d.display();
        System.out.println("size of DLL is: "+size);
        d.SearchList(78);

    }
}