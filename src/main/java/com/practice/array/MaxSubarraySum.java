package com.practice.array;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2,3,2,-1};
        System.out.println(findMaxSubArraySum(arr));
    }

    private static int findMaxSubArraySum(int[] arr) {
        int maxCurrent= arr[0] , maxGlobal = arr[0];
        for(int i=1;i<arr.length;i++){
            maxCurrent = Math.max(arr[i],maxCurrent+arr[i]);
            if(maxCurrent>maxGlobal){
                maxGlobal=maxCurrent;
            }
        }

        return maxGlobal;
    }
}
