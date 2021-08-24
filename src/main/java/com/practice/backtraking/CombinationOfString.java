package com.practice.Backtraking;

import java.util.Scanner;

public class CombinationOfString {
    /**
     * Given an input string, find the combination of all the characters in it.
     * For a string of length n , the total number of combinations it has is n! .
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        printAllCombinationOfCharacters(in, 0, in.length());
    }

    private static void printAllCombinationOfCharacters(String str, int left, int right) {

        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i < right; i++) {
                //do
                str = swap(str, left, i);
                //recur
                printAllCombinationOfCharacters(str, left + 1, right);
                //undo
                str = swap(str, left, i);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return String.valueOf(arr);
    }
}
