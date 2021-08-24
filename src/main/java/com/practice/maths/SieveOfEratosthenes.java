package com.practice.maths;

public class SieveOfEratosthenes {
    public static int getPrimeCount(int n){
        boolean[] flags = new boolean[n+1];
        for(int i=2;i*i<=n;i++){
            if(!flags[i]){
                for(int j=i*i;j<=n;j+=i){
                    flags[j]=true;
                }
            }
        }

        //get the count of primes
        int count=0;
        for(int i=2;i<=n;i++){
            if(!flags[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeCount(20));
    }
}
