package com.practice.multithreading;

public class PrintOddEvenByAlternateThreads {
    public static void main(String[] args) {
        SharedObject obj = new SharedObject(10);
        Thread1 t1 = new Thread1(obj);
        Thread2 t2 = new Thread2(obj);
        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread{
    SharedObject sharedObj;
    Thread1(SharedObject sharedObj){
        this.sharedObj=sharedObj;
    }
    @Override
    public void run(){
        try {
            synchronized (sharedObj) {
                while (sharedObj.num<sharedObj.limit) {
                    while (!sharedObj.isOdd) {
                        sharedObj.wait();
                    }
                System.out.println(sharedObj.num +Thread.currentThread().getName());
                //Thread.sleep(500);
                sharedObj.num++;
                sharedObj.isOdd = false;
                sharedObj.notifyAll();
            }
        }} catch (InterruptedException e) {
        e.printStackTrace();
        }
    }
}

class Thread2 extends Thread{
    SharedObject sharedObj;
    Thread2(SharedObject sharedObj){
        this.sharedObj=sharedObj;
    }
    @Override
    public void run(){
        try {
            synchronized (sharedObj) {
                while (sharedObj.num<sharedObj.limit) {
                    while (sharedObj.isOdd) {
                        sharedObj.wait();
                    }
                    System.out.println(sharedObj.num +
                            Thread.currentThread().getName());
                  //  Thread.sleep(1000);
                    sharedObj.num++;
                    sharedObj.isOdd = true;
                    sharedObj.notifyAll();
                }
            }} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SharedObject{
    int num;
    boolean isOdd;
    int limit;
    SharedObject(int limit){
        this.limit=limit;
        this.num = 1;
        isOdd = true;
    }
}
