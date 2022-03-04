package com.practice.multithreading;

public class MyThreadUsingRunnable implements Runnable{
    public int sharedInt;

    MyThreadUsingRunnable(int sharedInt){
        this.sharedInt=sharedInt;
    }

    @Override
    public void run(){
        System.out.println("Run method of the MyThreadUsingRunnable ");
    }

    public static void main(String[] args) {
        MyThreadUsingRunnable threadUsingRunnable = new MyThreadUsingRunnable(4);
        Thread thread = new Thread(threadUsingRunnable);
        thread.start();
    }
}
