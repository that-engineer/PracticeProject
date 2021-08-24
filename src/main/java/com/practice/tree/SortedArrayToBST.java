package com.practice.Tree;

public class SortedArrayToBST {
    public static Node constructBSTFromSortedArray(int[] arr,int left, int right){
        if(arr.length==0){
            return null;
        }
    int mid = left+(right-left)/2;
        Node root = new Node(arr[mid]);
        root.left=constructBSTFromSortedArray(arr,0,mid-1);
        root.right=constructBSTFromSortedArray(arr,mid+1,arr.length-1);
        return root;
    }
    public static void main(String[] args) {
        int[] arr = {-3,-1,0,2,5};
        IterativeDFS_Tree.inOrder(constructBSTFromSortedArray(arr,0,arr.length-1));
    }
}
