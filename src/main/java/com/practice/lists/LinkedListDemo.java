package com.practice.Lists;

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList list =  new LinkedList();
        list.addNode(new Node(1));
        list.addNode(new Node(2));
        list.addNode(new Node(3));
        list.addNode(new Node(4));
        list.addNode(new Node(5));
        list.printList(list.head);
        list.deleteNodeAtIndex(list.head,1);
        System.out.println();
        list.printList(list.head);
      //  LinkedList list1 =  new LinkedList();
      //  list.printList(list1.head);
    }
}
