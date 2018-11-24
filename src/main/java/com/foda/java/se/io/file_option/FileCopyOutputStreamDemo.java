package com.foda.java.se.io.file_option;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author pxz
 * @date 2018/11/22 0022-下午 1:37
 */
public class FileCopyOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        String res = "a.txt";
        String des = "a_copy.txt";

        fileCopyByStream(res,des);

    }

    public static void fileCopyByStream(String res,String des) throws IOException {
        //创建字节输入流对象
        FileInputStream fileInputStream = new FileInputStream(res);

        //创建字节输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(des);

        int len;
        byte[] bytes = new byte[1024];

        while((len=fileInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len);
            fileOutputStream.flush();
        }

        // 释放资源
        fileOutputStream.close();
        fileInputStream.close();
    }

}
