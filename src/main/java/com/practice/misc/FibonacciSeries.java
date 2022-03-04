package com.practice.misc;

import java.util.LinkedList;
import java.util.List;

public class FibonacciSeries {
    public static List<Integer> getFibonacci(int n){
        List<Integer> ans = new LinkedList<>();
        if(n==1){
            ans.add(1);
            return  ans;
        }else{
            int prev1 = 0;
            int prev2 = 1;
            int curr;
            ans.add(1);
            for(int i=2;i<=n;i++){
                curr=prev1+prev2;
                ans.add(curr);
                prev1 = prev2;
                prev2 = curr;

            }
            return  ans;
        }
    }

    /*public static List<Integer> getFibonacciRecursively(int n){
        List<Integer> ans = new LinkedList<>();
        if(n==1){
            ans.add(1);
            return ans;
        }else{

        }
    }*/

    public static void main(String[] args) {
       List<Integer> fibonacci = getFibonacci(6);
       for(int i:fibonacci){
           System.out.print(i+",");
       }
    }
}
