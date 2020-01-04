package com.edu.zzu;
/*
    1.显示锁：需要手动写代码控制加锁和解锁
    2.隐示锁：不需要自己写代码加锁和解锁（synchroized）

    synchronized 的三个使用方法
        1.同步实例方法，锁式当前实例对象
        2.同步类方 法，锁式当前类对象
        3.同步代码块，锁是括号里的对象

 */
//这个类是对象锁实例
public class Synchronize implements Runnable {
    static Synchronize synchronize=new Synchronize();


    public static void main(String[] args) {
        Thread t1=new Thread(synchronize);
        Thread t2=new Thread(synchronize);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished");


    }


   /* @Override
    public void run() {
        method();
    }
    //这是对象锁中的 方法锁形式
    public synchronized void method(){
        System.out.println("我的对象锁方法修饰形式，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }*/

    //下面演示对象锁中的代码块锁
    @Override
    public void run() {
        synchronized (this){
            System.out.println("我是对象锁的代码块形式，我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }
}
