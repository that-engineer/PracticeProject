package com.practice.StringManipulation;

public class A_to_i {
    public static int myAtoi(String s) {
        boolean isNegative=false;
        int l = s.length();
        if(l==0){
            return 0;
        }
        long number=0;
        for(int i=0;i<l;i++){
            if(!isValid(s.charAt(i))){
                return 0;
            }

            if(s.charAt(i)=='-'){
                isNegative=true;
            }

            if(s.charAt(i) >='0' && s.charAt(i) <='9'){
                number=number*10+(s.charAt(i)-'0');
            }

        }
        if(number!=0){
            if(isNegative){
                number=-number;
                if(number<Integer.MIN_VALUE){
                    number=Integer.MIN_VALUE;
                }

            }
            if(number>Integer.MAX_VALUE){
                number=Integer.MAX_VALUE;
            }
        }

        return (int) number;


    }

    public static int aToI(String s){
        boolean isNegative=false;
        int l = s.length();
        if(l==0){
            return 0;
        }
        long number=0;
        return 0;
    }

    static boolean isValid(char c)
    {
        return c == ' ' || c == '-' || c == '+' || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("asads-91283472332"));
        System.out.println(Integer.MIN_VALUE);
    }
}
