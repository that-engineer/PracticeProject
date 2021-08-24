package com.practice.lists;

public class LinkedList {
    Node head = null;

    public void addNode(Node node){
        if(head==null){
            this.head = node;
        }else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next=node;
        }
    }

    public void printList(Node head){
        if(head == null){
            System.out.println("List is empty");
        }
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }

    public Node deleteNodeAtIndex(Node head, int n){
        Node curr = head;
        if(head==null){
            return null;
        }
        if(n==1){
            this.head=head.next;
        }else{
            n--;
            while(n>1){
                curr= curr.next;
                n--;
            }
            curr.next=curr.next.next;
        }
        return head;
    }
    public Node deleteFromEnd(Node head, int n){

        return head;
    }
}
