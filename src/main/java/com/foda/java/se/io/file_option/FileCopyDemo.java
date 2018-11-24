package com.foda.java.se.io.file_option;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 数据源：
 * 		FileWriterDemo.java -- 读数据 -- FileReader
 * 目的地：
 * 		Copy.java -- 写数据 -- FileWriter
 * @author pxz
 * @date 2018/11/22 0022-上午 11:59
 */
public class FileCopyDemo {
    public static void main(String[] args) {
        copyFile();
    }
    public static void copyFile(){
        FileReader reader = null;
        FileWriter writer = null;

        try {
            //创建输入流
            reader = new FileReader("a.txt");

            //创建输出流
            writer = new FileWriter("b.txt");

            //读写数据
            int len ;
            char[] chars = new char[1024];
            while ((len = reader.read(chars)) != -1){
                writer.write(chars,0,len);
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //释放资源，先开后关
                if(writer != null){
                    writer.close();
                }

                if(writer != null){
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
