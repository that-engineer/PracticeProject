package com.practice;

import java.util.ArrayList;

public class Test {
    public static boolean isPalindromeString(String s){
        int l = s.length();
        s=s.toLowerCase();
        ArrayList<Character> cArr = new ArrayList<Character>();
        for(int i=0;i<l;i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='0' && s.charAt(i)<='9'){
                cArr.add(s.charAt(i));
            }
        }
        int size=cArr.size();
        boolean isOdd= size % 2 != 0;
        int mid = size/2;
        int m=0,n=0;
        if(isOdd){
            m=mid-1;n=mid+1;
            while(m>=0 && n<size){
                if(cArr.get(m)!=cArr.get(n)){
                    return false;
                }
                m--;
                n++;
            }
        }else{
            m=mid-1;n=mid;
            while(m>=0 && n<size){
                if(cArr.get(m)!=cArr.get(n)){
                    return false;
                }
                m--;
                n++;
            }
        }

        return true;
    }
    public static void main(String[] args) {
       // System.out.println("Hi there");
      //  System.out.println(Integer.MAX_VALUE+" , "+Integer.MIN_VALUE);
        int[] harr = new int[26];
      //  System.out.println(harr[25]);
        String s = "race a car";
        Character[] carr = {'a','b','c','f','r','t','h'};
      //  System.out.println(isPalindromeString(s));
        char i='2';char j='3';
        int z= i-'0'+j-'0';
        System.out.println(z);

    }
}
