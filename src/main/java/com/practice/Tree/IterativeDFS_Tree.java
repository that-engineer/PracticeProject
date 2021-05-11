package com.practice.Tree;

import java.util.Stack;

public class IterativeDFS_Tree {
    public static void inOrder(Node root){
        Stack<Node> s = new Stack<Node>();
        while(root!=null || !s.isEmpty()){
            if(root!=null){
                s.push(root);
                root=root.left;
            }else {
                root=s.pop();
                System.out.print(root.data+",");
                root=root.right;
            }
        }
    }

    public static void preOrder(Node root) {
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            System.out.print(root.data+",");
            if (root.right != null)
                s.push(root.right);
            if (root.left != null)
                s.push(root.left);
        }
    }
    public static void postOrder(Node root){
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.print(s2.pop().data+",");
        }
    }
    public static void main(String[] args) {
        Node node = BSTSearch.createBST();
        inOrder(node);
        System.out.println();
        preOrder(node);
        System.out.println();
        postOrder(node);
    }
}
