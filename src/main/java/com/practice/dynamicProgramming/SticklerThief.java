package com.practice.dynamicProgramming;

public class SticklerThief {
    public static void main(String[] args) {
        int[] arr = {5,5,10,100,10,5};
        System.out.println(FindMaxSum(arr,arr.length));
    }
    public static int FindMaxSum(int[] arr, int n)
    {
        // Your code here
        int[] dp = new int[n+1];
        int res = FindMaxSumUtil(arr,0,n,dp);
        for (int i:dp
        ) {
            System.out.print(i+",");
        }
        System.out.println();
        return res;

    }
    public static int FindMaxSumUtil(int[] arr, int s, int n, int[] dp){

        if((n-s-1)<=1){
            return arr[s];
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=s;i<n;i++){
            if(i+2<n){
                int sum =0;
                if(dp[i+1]!=0){
                   dp[i] = arr[i]+dp[i+2];
                } else{
                    dp[i] = arr[i]+FindMaxSumUtil(arr,i+2,n,dp);
                }
                maxSum = Math.max(sum,dp[i]);
            }

        }
        return maxSum;
    }
}
