package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static boolean isPalindromeString(String s){
        int l = s.length();
        s=s.toLowerCase();
        ArrayList<Character> cArr = new ArrayList<Character>();
        for(int i=0;i<l;i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9'){
                cArr.add(s.charAt(i));
            }
        }
        int size=cArr.size();
        boolean isOdd= size % 2 != 0;
        int mid = size/2;
        int m=0,n=0;
        if(isOdd){
            m=mid-1;n=mid+1;
            while(m>=0 && n<size){
                if(cArr.get(m)!=cArr.get(n)){
                    return false;
                }
                m--;
                n++;
            }
        }else{
            m=mid-1;n=mid;
            while(m>=0 && n<size){
                if(cArr.get(m)!=cArr.get(n)){
                    return false;
                }
                m--;
                n++;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        t.left.left= new TreeNode(4);
        t.left.right= new TreeNode(3);
        printLevelOrderTraversal(t);
        System.out.println();
        printBFS_InOrderTraversal(t);
        System.out.println();
        printBFS_PreOrderTraversal(t);
        System.out.println();
        printBFS_PostOrderTraversal(t);

    }

    private static void printBFS_InOrderTraversal(TreeNode root) {
        if(root==null){
            System.out.println("Empty");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            System.out.print(root.data+" ");
            root=root.right;
        }
    }

    private static void printBFS_PreOrderTraversal(TreeNode root) {
        if(root==null){
            System.out.println("Empty");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            root = s.pop();
            System.out.print(root.data+" ");
            while(root!=null) {
                root = root.left;
                s.push(root);
            }
            root=root.right;
        }
    }

    private static void printBFS_PostOrderTraversal(TreeNode root) {
        if(root==null){
            System.out.println("Empty");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(root!=null || !s.isEmpty()){
            if(root.right!=null){
                s.push(root.right);
            }
            if(root.left!=null){
                s.push(root.left);
            }
            root=root.left;
        }
    }

    private static void printLevelOrderTraversal(TreeNode root) {
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        Queue<TreeNode> s = new LinkedList<TreeNode>();
        s.add(root);
        while(!s.isEmpty()){
            root = s.poll();
            System.out.print(root.data+" ");
            if(root.left!=null){
                s.add(root.left);
            }
            if(root.right!=null){
                s.add(root.right);
            }

        }
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(){
        left=null;
        right=null;
    }

    TreeNode(int data){
        left = null;
        right= null;
        this.data = data;
    }
}
