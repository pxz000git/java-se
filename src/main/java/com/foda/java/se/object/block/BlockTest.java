package com.foda.java.se.object.block;

/**
 * @author pxz
 * @date 2018/11/22 0022-下午 2:09
 */
public class BlockTest {
    {
        System.out.println("构造代码块");
    }
    static {
        System.out.println("静态代码块--1");
    }


    BlockTest(){
        System.out.println("无参构造方法");
    }

    public static void main(String[] args) {
        System.out.println("BlockTest 主函数");

        new Coder();
    }
}
class Coder {

    static {
        System.out.println("Coder静态代码块执行--2");
    }

    {
        System.out.println("Coder构造代码块执行--3");
    }

    public Coder() {
        System.out.println("Coder无参空构造执行--4");
    }

}
