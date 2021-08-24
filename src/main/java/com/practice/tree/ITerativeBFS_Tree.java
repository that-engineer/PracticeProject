package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ITerativeBFS_Tree {
    public static void Iterative_BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            root = q.poll();
            System.out.print(root.data+",");
            if(root.left!=null){
                q.add(root.left);
            }
            if(root.right!=null){
                q.add(root.right);
            }
        }
    }
    public static void main(String[] args) {
        Node node = BSTSearch.createBST();
        Iterative_BFS(node);

    }
}
