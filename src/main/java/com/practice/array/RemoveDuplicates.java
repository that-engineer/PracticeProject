package com.practice.array;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr){
        int start=1,NOD=1;
        for(int i = 1; i<arr.length;i++){
            if(arr[i-NOD]!=arr[i]){
                arr[start++] = arr[i];
            }
        }
        for (int i : arr
             ) {
            System.out.print(i+", ");
        }
        System.out.println();
        return start;
    }
    public static int removeDuplicates(int[] nums,int n){
        int duplicatesAllowed = 1;
        int start = duplicatesAllowed;
        int end = duplicatesAllowed;
        while (end < n) {
            if (nums[start - duplicatesAllowed] != nums[end]) {
                nums[start++] = nums[end];
            }
            end++;
        }
        for (int i : nums
        ) {
            System.out.print(i+", ");
        }
        System.out.println();
        return start;
    }
    public static void main(String[] args) {

      int[] arr = {0,0,1,1,2,2,3,3,4};
        //int[] arr = {1,1,2,4};
       // int[] arr = {0,1,2,3,4};
     //  int[] arr = {1,1,2,3,3,4};
       System.out.println(removeDuplicates(arr));
        System.out.println();
        System.out.println(removeDuplicates(arr,arr.length)+" 2nd method");

    }
}
