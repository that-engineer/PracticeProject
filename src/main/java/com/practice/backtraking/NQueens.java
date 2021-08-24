package com.practice.backtraking;

import java.util.Scanner;

public class NQueens {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] mat = new boolean[n][n];
        //(board,row,col,totalNoOfQueens,queensPlacedSoFar,ans)
        findQueensPosition(mat,0,0,n,0,"");
    }

    private static void findQueensPosition(boolean[][] board, int row, int col,int noOfQueens,int queensPlacedSoFar,String ans){

        if(queensPlacedSoFar==noOfQueens){
            System.out.println(ans);
            return;
        }
        if(col==board[0].length){
            row++;
            col = 0;
        }
        if(row==board.length){
            return;
        }
        //placing a queen at a position
        if(isSafeToPlaceAQueen(board,row,col)){
            //do something
            board[row][col]= true;
            // recur
            findQueensPosition(board,row,col+1,noOfQueens,queensPlacedSoFar+1,ans+"["+row+","+col+"]");
            // undo the change
            board[row][col]= false;

        }

        //else place at next position
        findQueensPosition(board,row,col+1,noOfQueens,queensPlacedSoFar,ans);
    }
    private static boolean isSafeToPlaceAQueen(boolean[][] board, int row, int col){
        //check in horizontal up
        int r= row-1;
        int c = col;
        while(r>=0){
            if(board[r][c]){
                return false;
            }
            r--;
        }

        //check in vertically left
         r= row;
         c = col-1;
        while(c>=0){
            if(board[r][c]) {
                return false;
            }
            c--;
        }

        //check in diagonally left
         r= row-1;
         c = col-1;
        while(r>=0 && c>=0){
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }

        //check in diagonally right
        r= row-1;
        c = col+1;
        while(r>=0 && c< board[0].length){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }

     return true;
    }
}
