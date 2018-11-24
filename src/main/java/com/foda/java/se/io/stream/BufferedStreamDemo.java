package com.foda.java.se.io.stream;

import java.io.*;

/**
 * BufferedWriter:将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
 * BufferedReader:从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
 * @author pxz
 * @date 2018/11/22 0022-下午 12:09
 */
public class BufferedStreamDemo {
    public static void main(String[] args) {
        bufferedStreamFun();
    }
    public static void bufferedStreamFun(){
        try {
            //创建输出缓冲流
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c.txt"));

            bufferedWriter.write("hello");
            bufferedWriter.flush();

            //释放资源
            bufferedWriter.close();

            //创建输入缓冲流
            BufferedReader bufferedReader = new BufferedReader(new FileReader("c.txt"));

            int len;
            char[] chars = new char[1024];
            while ((len=bufferedReader.read(chars)) != -1){
                String s = new String(chars, 0, len);
                System.out.println(String.format("读取数据s:%s",s));
            }

            //释放资源
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
