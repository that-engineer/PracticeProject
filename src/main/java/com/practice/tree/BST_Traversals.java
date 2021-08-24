package com.practice.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BST_Traversals {
    public static void main(String[] args) {
        Node node = BSTSearch.createBST();
        recursiveInorderTraversal(node);
        System.out.println();
        printIterativeInorderTraversalUsingStack(node);
        System.out.println();
        recursivePreorderTraversal(node);
        System.out.println();
        printIterativePreorderTraversalUsingStack(node);
        System.out.println();
        recursivePostorderTraversal(node);
        System.out.println();
        System.out.println(iterativePostorderTraversalUsingOneStackReturningList(node));

        printIterativePostorderTraversalUsingTwoStack(node);
        printIterativePostorderTraversalUsingOneStack(node);


    }

    private static List<Integer> iterativePostorderTraversalUsingOneStackReturningList(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root==null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(0,root.data);
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
        return list;
    }

    private static void printIterativePostorderTraversalUsingOneStack(Node root) {

    }

    private static void printIterativePostorderTraversalUsingTwoStack(Node root) {
        if(root==null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left!=null){
                stack1.push(root.left);
            }
            if(root.right!=null){
                stack1.push(root.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+",");
        }
    }

    private static void printIterativePreorderTraversalUsingStack(Node root) {
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.data+",");
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
    }

    private static void printIterativeInorderTraversalUsingStack(Node root) {
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.data+",");
            root=root.right;
        }
    }


    private static void recursivePostorderTraversal(Node root) {
        if(root==null){
            return;
        }
        recursivePostorderTraversal(root.left);
        recursivePostorderTraversal(root.right);
        System.out.print(root.data+",");
    }

    private static void recursivePreorderTraversal(Node root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+",");
        recursivePreorderTraversal(root.left);
        recursivePreorderTraversal(root.right);
    }

    private static void recursiveInorderTraversal(Node root) {
        if(root==null) {
            return;
        }
        recursiveInorderTraversal(root.left);
        System.out.print(root.data+",");
        recursiveInorderTraversal(root.right);
    }
}
