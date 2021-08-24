package com.practice.tree;

public class BinaryTreeDemo {

    public static void main(String[] sdf) {
        System.out.println("Binary Tree Demo -");
        Node node = new Node(10);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(6);
        node.right.left = new Node(8);
        node.right.right = new Node(3);

        System.out.println("Pre Order Traversal ");
        Node.preOrderTraversal(node);

        System.out.println("Post Order Traversal ");
        Node.postOrderTraversal(node);

        System.out.println("In Order Traversal ");
        Node.inOrderTraversal(node);
    }
}
