package com.practice.array;

public class MaxVolOfWater {
    public static int maxArea(int[] height) {
        int lptr = 0 , rptr = height.length-1;
        int area = 0;
        while(lptr<rptr){
            int l = rptr-lptr;
            int h = Math.min(height[lptr],height[rptr]);
            area = Math.max(l*h,area);
            if(height[lptr]>height[rptr]){
                rptr--;
            }else if(height[lptr]<height[rptr]){
                lptr++;
            }else{
                int tl = lptr, tr = rptr;
                if(height[++tl]<=height[--tr]){
                    lptr++;
                }else{
                    rptr--;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,25,24,5};
        System.out.println(maxArea(arr));
    }
}
