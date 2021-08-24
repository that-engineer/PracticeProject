package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public static boolean isValidBSTRecursive(Node root){
       return isValidBST(root, Long.MAX_VALUE,Long.MIN_VALUE);
    }
    private static boolean isValidBST(Node root, long maxValue, long minValue) {
        if(root==null){
            return true;
        }else if(root.data>=maxValue || root.data<=minValue){
            return false;
        }else{
            return isValidBST(root.left,root.data,minValue) && isValidBST(root.right,maxValue, root.data);
        }
    }

    public static List<Node> isValidBSTIterative(Node root){
        List<Node> list = new ArrayList<Node>();
        if(root==null){
            return list;
        }
        Stack<Node> stack = new Stack<Node>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root= root.left;
            }
            root=stack.pop();
            list.add(root);
            root = root.right;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Binary Tree Demo -");
        Node node = new Node(2147483647);
        /*node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(6);
        node.right.left = new Node(8);
        node.right.right = new Node(3);*/
        System.out.println(isValidBSTRecursive(node));
    }

}
