package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public static void main(String[] args) {
        //Create a graph from a list of connected vertices and no of nodes
        List<String> edges = new ArrayList<>();
        edges.add("1 2");
        edges.add("1 3");
        edges.add("2 4");
        edges.add("3 5");
        edges.add("7 8");

        int nodes = 10;

        ArrayList<ArrayList<Integer>> graph = createGraphViaAdjacencyList(edges,nodes);
        printGraph(graph);
        System.out.println("DFS of Graph");
        DFS(graph,nodes);
        System.out.println("Connected Sum of the Graph");
        System.out.println(connectedSumUsingDFS(graph,nodes));
    }

    public static ArrayList<ArrayList<Integer>> createGraphViaAdjacencyList(List<String> edges, int nodes) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0;i<=nodes;i++){
                graph.add(new ArrayList<Integer>());
            }

            for (String edge: edges) {
                String[] uv = edge.split(" ");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            return graph;
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj)    {
        for (int i = 1; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void DFS(ArrayList<ArrayList<Integer>> graph, int nodes){
        boolean[] visited = new boolean[nodes+1];
        for(int i=1;i<=nodes;i++){
            if(!visited[i]){
                DFSUtil(i,graph,visited);
            }
            System.out.println();
        }
    }

    private static void DFSUtil(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        System.out.print(i+" , ");
        for(int n :graph.get(i)){
            if(!visited[n]){
                DFSUtil(n,graph,visited);
            }
        }
    }

    public static int connectedSumUsingDFS(ArrayList<ArrayList<Integer>> graph,int nodes){
        boolean[] visited = new boolean[nodes+1];
        int sum = 0;
        for(int i=1;i<=nodes;i++){
            if(!visited[i]){
                List<Integer> connectedComponent = new ArrayList<>();
                connectedSumDFSUtil(i,graph,visited,connectedComponent);
                int connectedNodes = connectedComponent.size();
                sum += (connectedNodes > 1) ? Math.ceil(Math.sqrt(connectedNodes)) : 1;
            }
        }
        return sum;
    }

    private static void connectedSumDFSUtil(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited, List<Integer> connectedComponent) {

        visited[i] = true;
        connectedComponent.add(i);
        for (int n : graph.get(i)
             ) {
            if(!visited[i])
                connectedSumDFSUtil(n,graph,visited,connectedComponent);
        }
    }
}

