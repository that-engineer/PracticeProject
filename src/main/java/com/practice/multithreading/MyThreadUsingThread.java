package com.practice.multithreading;

public class MyThreadUsingThread extends Thread{
    public int sharedInt;
    MyThreadUsingThread(int sharedInt){
        this.sharedInt = sharedInt;
    }
    public void run(){
        System.out.println("Run method of the MyThreadUsingThread "+this.sharedInt);
    }

    public static void main(String[] args) {
        MyThreadUsingThread thread = new MyThreadUsingThread(4);

        thread.start();
    }
}
