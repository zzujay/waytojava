package com.edu.zzu;

public class ClassLock2 implements Runnable{
    static  ClassLock2 classLock=new ClassLock2();
    static ClassLock2 classLock1=new ClassLock2();
    @Override
    public void run() {
        method();
    }
    private void method() {
        synchronized (ClassLock2.class){
            System.out.println("我是类锁的第二种形式：synchronized,我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"该线程执行完毕");

        }

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
