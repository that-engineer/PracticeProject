package com.practice.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeView {
    public static void main(String[] args) {
        Node node = BSTSearch.createBST();
        TreeMap<Integer,int[]> map = new TreeMap<>();
        getTopViewOfTreeRecursive(node,1,0,map);
        printMapValues(map);
        System.out.println();
        printTopViewOfTreeIterative(node);
        System.out.println();
        map.clear();
        getBottomViewOfTreeRecursively(node,map,0,0);
        printMapValues(map);
        System.out.println();
        printBottomViewOfTreeIterative(node);
    }

    private static void getTopViewOfTreeRecursive(Node root,int level,int distFromRoot,TreeMap<Integer,int[]>map) {
        if (root == null)
            return;

        if (!map.containsKey(distFromRoot)) {
            map.put(distFromRoot, new int[]{root.data, level});
        }
        else if (map.get(distFromRoot)[1] > level) {
            map.put(distFromRoot, new int[]{root.data, level});
        }
        getTopViewOfTreeRecursive(root.left,level+1,distFromRoot-1,map);
        getTopViewOfTreeRecursive(root.right,level+1,distFromRoot+1,map);
    }

    private static void printTopViewOfTreeIterative(Node root){
        if(root==null){
            return ;
        }
        Queue<QueueObj> queue = new LinkedList<>();
        queue.offer(new QueueObj(root,0));
        TreeMap<Integer,Node> map = new TreeMap<>();
        while(!queue.isEmpty()){
            QueueObj currE = queue.poll();
            if(!map.containsKey(currE.hd)){
                map.put(currE.hd,currE.node);
            }
            if(currE.node.left != null){
                queue.offer(new QueueObj(currE.node.left,currE.hd-1));
            }
            if(currE.node.right != null){
                queue.offer(new QueueObj(currE.node.right,currE.hd+1));
            }
        }

        for(Map.Entry<Integer,Node> entry : map.entrySet()){
            System.out.print(entry.getValue().data+" , ");
        }
    }

    private static void getBottomViewOfTreeRecursively(Node root,TreeMap<Integer,int[]> map,int horizontalDist,int level){
        if(root==null){
            return ;
        }
        if(!map.containsKey(horizontalDist)){
            map.put(horizontalDist,new int[]{root.data,level});
        }else{
            if(map.get(horizontalDist)[1]<level){
                map.put(horizontalDist,new int[]{root.data,level});
            }
        }
        getBottomViewOfTreeRecursively(root.left,map,horizontalDist-1,level+1);
        getBottomViewOfTreeRecursively(root.right,map,horizontalDist+1,level+1);

    }

    private static void printBottomViewOfTreeIterative(Node root){
        if(root==null){
            return;
        }
        Queue<QueueObj> queue = new LinkedList<>();
        queue.offer(new QueueObj(root,0));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while (!queue.isEmpty()){
            QueueObj currObj = queue.poll();
            map.put(currObj.hd,currObj.node.data);

            if(currObj.node.left!=null){
                queue.offer(new QueueObj(currObj.node.left,currObj.hd-1));
            }
            if(currObj.node.right!=null){
                queue.offer(new QueueObj(currObj.node.right,currObj.hd+1));
            }
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()
             ) {
            System.out.print(entry.getValue()+" , ");
        }

    }
    private static void printMapValues(TreeMap<Integer,int[]> map){
        for (Map.Entry<Integer,int[]> entry: map.entrySet()
             ) {
            System.out.print(entry.getValue()[0]+" , ");
        }
    }
    static class QueueObj{
        Node node;
        Integer hd;

        QueueObj(Node node, Integer hd){
            this.node = node;
            this.hd = hd;
        }
    }
}
