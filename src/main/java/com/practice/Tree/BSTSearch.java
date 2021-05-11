package com.practice.Tree;

public class BSTSearch {
    public static Node createBST(){
        Node node = new Node(10);
        node.left = new Node(-5);
        node.right = new Node(25);
        node.left.left = new Node(-10);
        node.left.right = new Node(5);
        node.right.right = new Node(36);

        return node;
    }

    public static Node search(Node node, int key){
        if(node==null){
            return null;
        }
        if(node.data==key){
            return node;
        }
        if(node.data>key){
            return search(node.left,key);
        }else{
            return search(node.right,key);
        }
    }
    public static void main(String[] args){
        Node node = search(createBST(),5);
        System.out.println("Key found at com.practice.Tree.Node "+node+" Data : "+node.data);
    }
}
