package com.foda.java.se.thread;

/**
 * 问题出现的原因：
 * 		要有多个线程
 * 		要有被多个线程所共享的数据
 * 		多个线程并发的访问共享的数据
 *
 * 在火车上上厕所
 * 张三来了，一看门是绿的，他就进去了，把门锁上了，门就变红了
 * 李四来了，一看门市红色的，他就只能憋着
 * 张三用完了厕所，把锁打开了，门就变成了绿色
 * 李四一看门变绿了，他就进去了，把门锁上，门就变红了
 * 王五来了，一看们是红色的，他也只能憋着
 * 李四用完厕所了，把锁打开了，肚子又不舒服了，扭头回去了，又把门锁上了
 *
 * synchronized:同步（锁），可以修饰代码块和方法，被修饰的代码块和方法一旦被某个线程访问，则直接锁住，其他的线程将无法访问
 *
 * 同步代码块：
 * 			synchronized(锁对象){
 *
 * 			}
 * 同步非静态方法：
 *   public synchronized void method(){}
 * 同步静态方法：
 *   public static synchronized void method(){}
 *
 * 非静态的同步方法的锁对象是 this
 * 非静态的同步方法的锁对象是 当前类的字节码对象
 *
 * 	注意：锁对象需要被所有的线程所共享
 *
 * 	同步：安全性高，效率低
 * 非同步：效率高，但是安全性低
 *
 *
 * @author pxz
 * @date 2018/11/22 0022-下午 4:56
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        TicketThread thread = new TicketThread();

        Thread thr1 = new Thread(thread);
        thr1.setName("窗口1");

        Thread thr2 = new Thread(thread);
        thr2.setName("窗口1");

        Thread thr3 = new Thread(thread);
        thr3.setName("窗口1");

        //启动线程对象
        thr1.start();
        thr2.start();
        thr3.start();

    }
}
//class TicketThread implements Runnable{
//
//    // 火车票数量
//    int tickets = 100;
//    Object obj = new Object();
//
//    @Override
//    public void run() {
//        //出手火车票
//        while(true){
//            synchronized (obj){
//                if(tickets > 0){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(Thread.currentThread() + ":" +tickets--);
//                }
//            }
//
//        }
//    }
//}

/*
 * 同步方法:使用关键字synchronized修饰的方法，一旦被一个线程访问，则整个方法全部锁住，其他线程则无法访问
 *
 * synchronized
 * 注意：
 * 		非静态同步方法的锁对象是this
 * 		静态的同步方法的锁对象是当前类的字节码对象
 */
class TicketThread implements Runnable {
    static int tickets = 100;// 火车票数量
    Object obj = new Object();

    public void run() {
        // 出售火车票
        while (true) {
			/*synchronized (obj) {
				method();
			}*/

            method();
            //method2();

        }
    }

    /**
     * synchronized修饰非静态方法，使之成为锁
     */
    private synchronized void method() {
        if (tickets > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":" + tickets--);
        }
    }

    /**
     * synchronized修饰静态方法，使之成为锁
     */
    //private static synchronized void method2() {
    //
    //    if (tickets > 0) {
    //
    //        try {
    //            Thread.sleep(100);
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //
    //        System.out.println(Thread.currentThread().getName() + ":" + tickets--);
    //    }
    //}

}
