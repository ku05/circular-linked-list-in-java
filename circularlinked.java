import java.util.*;
class circularlinked{
    Node head,newnode,temp,tail,prevnode,currnode,nextnode;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void create(){
        Scanner sc=new Scanner(System.in);
        head=null;
        int i=1;
        while(i<=5){
            System.out.println("Enter the data:");
            int x=sc.nextInt();
            Node newnode=new Node(x);
            if(head==null){
                head=tail=newnode;
                newnode.next=head;
            }else{
                tail.next=newnode;
                newnode.next=head;
                tail=newnode;
            }
            i++;
        }
    }
    public void addfirst(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data to add first:");
        int x=sc.nextInt();
        Node newnode=new Node(x);
        newnode.next=head;
        head=newnode;
        tail.next=head;
    }
    public void addlast(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data to add last:");
        int x=sc.nextInt();
        Node newnode=new Node(x);
        tail.next=newnode;
        newnode.next=head;
        tail=newnode;
    }
    public void addpos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the position to add data:");
        int pos=sc.nextInt();
        int i=1;
        temp=head;
        if(pos==1)
        {
            addfirst();
        }else{
            while(i<pos-1){
                temp=temp.next;
                i++;
            }
            System.out.println("Enter the data to add pos:");
            int x=sc.nextInt();
            Node newnode=new Node(x);
            newnode.next=temp.next;
            temp.next=newnode;
        }
    }
    public void deletefirst(){
        System.out.println("First node is deleted:");
        head=head.next;
        tail.next=head;
    }
    public void deletelast(){
        System.out.println("Last node is deleted:");
        temp=head;
        while(temp.next!=head){
            prevnode=temp;
            temp=temp.next;
        }
        prevnode.next=head;
    }
    public void deletepos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the position to delete data:");
        int pos=sc.nextInt();
        int i=1;
        temp=head;
        if(pos==1){
            deletefirst();
        }else{
            while(i<pos-1){
                temp=temp.next;
                i++;
            }
            nextnode=temp.next;
            temp.next=nextnode.next;
        }
    }
    public void display(){
        System.out.println("Circular linked list is:");
        temp=head;
        while(temp.next!=head){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print(temp.data+"->");
        System.out.println("null");
        System.out.println("Circular last node data is:"+tail.next.data);
    }
    public static void main(String args[]){
        circularlinked list=new circularlinked();
        list.create();
        list.display();
        list.addfirst();
        list.display();
        list.addlast();
        list.display();
        list.addpos();
        list.display();
        list.deletefirst();
        list.display();
        list.deletelast();
        list.display();
        list.deletepos();
        list.display();
    }
}