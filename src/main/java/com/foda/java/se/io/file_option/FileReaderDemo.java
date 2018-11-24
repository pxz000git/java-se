package com.foda.java.se.io.file_option;

import java.io.FileReader;
import java.io.IOException;

/**
 * 从文件中读数据并显示到控制台
 * 		读数据--输入流--FileReader
 * 	输入流读文件的步骤：
 * 		A:创建输入流对象
 * 		B:调用输入流对象的读数据方法
 * 		C:释放资源
 * @author pxz
 * @date 2018/11/22 0022-上午 11:41
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        fileReaderChar();
    }
    public static void fileReader(){
        FileReader reader = null;
        try {
            reader = new FileReader("a.txt");

            //一次读取一个字符
            int ch ;

            //如果读取数据的返回值是-1的时候，就说明没有数据了，这也是我们循环的结束条件
            while ((ch = reader.read()) != -1){
                //System.out.println(ch);
                System.out.println((char)ch);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void fileReaderChar(){
        FileReader reader = null;
        try {
            reader = new FileReader("a.txt");
            int len;
            char[] chars = new char[1024];

            while ((len = reader.read(chars))!=-1){
                System.out.println(len);
                System.out.println(new String (chars,0,len));
            }

            //释放资源
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
