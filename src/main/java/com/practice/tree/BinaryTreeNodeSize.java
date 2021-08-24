package com.practice.tree;

public class BinaryTreeNodeSize {
    public static int binaryTreeSize(Node node){
        if (node==null)
                return 0;

        return 1+binaryTreeSize(node.left)+binaryTreeSize(node.right);
    }
    public static void main(String[] args) {
        Node node = BSTSearch.createBST();
        System.out.println(binaryTreeSize(node));
    }
}
