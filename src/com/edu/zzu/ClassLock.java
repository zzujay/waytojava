package com.edu.zzu;
/*
类锁 ：java类可能有很多个对象，但只有1个Class对象
形式1 synchronized加在static方法上，该形式在全局使用 而不是只限于一个对象
形式2 synchornized 代码块 synchronized（.class）代码块

 */
public class ClassLock implements Runnable {
    static ClassLock classLock=new ClassLock();
    static ClassLock classLock1=new ClassLock();


    @Override
    public void run() {
        method();
    }
    public static  synchronized void method(){
        System.out.println("我是类锁的第一种形式：static 我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");

    }
    public static void main(String[] args) {
        Thread thread=new Thread(classLock);
        Thread thread1=new Thread(classLock1);
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finished");
    }
}
