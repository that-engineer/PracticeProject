package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevelTraversal {
    public static void printBTLevelByLevelwithDelimitter(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            root = q.poll();
            if(root!=null){
                System.out.print(root.data+",");
                if(root.left!=null){
                    q.offer(root.left);
                }
                if(root.right!=null){
                    q.offer(root.right);
                }
            }else{
                if(q.isEmpty())
                    break;
                System.out.println();
                q.offer(null);
            }
        }
    }
    public static void printBTLevelByLevel(Node root){
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()){
            while (!q1.isEmpty()){
                root = q1.poll();
                System.out.print(root.data+",");
                if(root.left!=null){
                    q2.add(root.left);
                }
                if(root.right!=null){
                    q2.add(root.right);
                }
                if(q1.isEmpty()){
                    System.out.println();
                }
            }
            while(!q2.isEmpty()){
                root = q2.poll();
                System.out.print(root.data+",");
                if(root.left!=null){
                    q1.add(root.left);
                }
                if(root.right!=null){
                    q1.add(root.right);
                }
                if(q2.isEmpty()){
                    System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) {
        Node node = BSTSearch.createBST();
        printBTLevelByLevel(node);
        printBTLevelByLevelwithDelimitter(node);
    }
}
