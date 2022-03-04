package com.practice.dynamicProgramming;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(getFibonacciRecursively(10));
        System.out.println(getFibonacciDP(10));
    }
    public static int getFibonacciRecursively(int n){
        if(n<=0){
            return 0;
        } else if(n==1){
            return n;
        }
        return getFibonacciRecursively(n-1)+getFibonacciRecursively(n-2);
    }

    public static int getFibonacciDP(int n){
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<2){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
}
