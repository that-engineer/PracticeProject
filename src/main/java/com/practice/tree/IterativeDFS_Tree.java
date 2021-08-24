package com.practice.Tree;

import java.util.HashMap;
import java.util.Map;
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

    public static void traversal_trick(Node root){
        Map<Node,Integer> cnt = new HashMap<Node,Integer>();
        //inorder
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while(!s.empty()){
            Node cur = s.peek();
            if(cur != null) {
            cnt.put(cur,0);
            if (cnt.get(cur) == 0) s.push(cur.left);
            else if (cnt.get(cur) == 1) System.out.println(root.data);
            else if (cnt.get(cur) == 2) s.push(cur.right);
            else s.pop();
            Integer val = cnt.get(cur);
            cnt.put(cur,val++);
        }}
    }
    public static void main(String[] args) {
        Node node = BSTSearch.createBST();
        inOrder(node);
        System.out.println();
       // preOrder(node);
        System.out.println();
       // postOrder(node);
        traversal_trick(node);
    }
}
