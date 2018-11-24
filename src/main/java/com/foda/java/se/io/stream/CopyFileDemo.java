package com.foda.java.se.io.stream;

import java.io.*;

/**
 * void newLine():写一个换行符，这个换行符由系统决定
 * String readLine():一次读取一行数据，但是不读取换行符
 * @author pxz
 * @date 2018/11/22 0022-下午 12:16
 */
public class CopyFileDemo {
    public static void main(String[] args) {
        bufferedStreamDemo();
    }
    public static void copyFile(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("a.txt"));

            int len;
            char[] chars = new char[1024];

            bufferedWriter = new BufferedWriter(new FileWriter("d.txt"));

            while ((len=bufferedReader.read(chars)) != -1){
                bufferedWriter.write(chars,0,len);
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void bufferedStreamDemo(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("d.txt"));

            int ch = reader.read();
            int ch2 = reader.read();
            System.out.println(ch);
            System.out.println(ch2);

            //读取一行，记录上次被读取的字符串的位置，往后读完该行
            //一次读取一行数据，但是不读取换行符
            String s = reader.readLine();
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
