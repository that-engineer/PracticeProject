package com.practice.dynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int n = 18;
        int[] denominations = {7,5,1};
        int[] dp = new int[19];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        System.out.println(minCoins(n,denominations, dp));
    }
    public static int minCoins(int n, int[] denominations,int[] dp){
        if(n==0) return 0;

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<denominations.length;i++){
            if(n-denominations[i]>=0){
                int subAns = 0;
                if(dp[n-denominations[i]]!=-1) {
                    subAns = dp[n-denominations[i]];
                } else {
                    subAns = minCoins(n - denominations[i], denominations, dp);
                }
                if(subAns!= Integer.MAX_VALUE && subAns+1<ans){
                    ans = subAns+1;
                }
            }
        }
        dp[n] = ans;
        return ans;
    }
}
