package com.foda.java.se.thread;

/**
 * 多线程：
 *  进程：当前正在运行的程序，一个应用程序在内存中的执行区域
 *  线程：进程中的一个执行控制单元，执行路径
 *
 *  一个进程可以有一个线程，也可以有多个线程
 *
 *  单线程：安全性高，但是效率低
 *  多线程：安全性低，效率高
 *
 *  多线程：360，迅雷
 *  实现方式1：Thread的子类，该子类重写Thread的run方法，接下来可以分配并启动子类的实例
 *      Thread
 *          getName()返回该线程的名称
 *          setName(String name) 改变线程的名称
 *  实现方式2：实现Runnable接口的类，然后该类实现run方法，然后可以分配该类的实例
 *          再创建Thread()把实例作为一个参数来传递并启动
 *
 * 主方法也是一个线程
 *
 * CPU 执行程序的随机性
 * 线程的生命周期：新建，就绪(有执行条件，没有被执行)，运行（执行），消亡
 *               新建-->就绪-->等待(wait（休息）,notify（唤醒）)-->就绪-->运行-->消亡
 *
 * @author pxz
 * @date 2018/11/22 0022-下午 4:20
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //// 创建线程实例
        //MyThread thread = new MyThread();
        //
        //thread.setName("thread01");
        ////启动线程
        //thread.start();
        //
        //// 创建线程实例
        //MyThread thread2 = new MyThread();
        //
        //thread2.setName("thread02");
        ////启动线程
        //thread2.start();


        // 创建线程实例
        MyThread2 myThread2 = new MyThread2(100);
        Thread thread = new Thread(myThread2);
        thread.setName("thread01");

        //启动线程
        thread.start();

        //MyThread2 myThread21 = new MyThread2(200);
        Thread thread2 = new Thread(myThread2);
        thread2.setName("thread02");

        //启动线程
        thread2.start();
    }

}
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(getName() + ":" + i);
        }
    }
}
class MyThread2 implements Runnable{
    int num;

    public MyThread2(int num) {
        this.num = num;
    }

    public void run() {
        for(int i = 0;i<100;i++){
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + ",i is :" + i + ",num is:" + num--);
        }
    }
}
