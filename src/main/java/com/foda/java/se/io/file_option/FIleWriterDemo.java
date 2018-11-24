package com.foda.java.se.io.file_option;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 往文件中写数据
 *  -- 输出流 -- FileWriter
 *  输出流写数据的步骤：
 * 		A:创建输出流对象
 * 		B:调用输出流对象的写数据的方法
 * 		C:释放资源
 * close()和flush()方法的区别：
 * 		flush():刷新缓冲区。流对象还可以继续使用。
 * 		close():先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了
 * @author pxz
 * @date 2018/11/22 0022-上午 10:59
 */
public class FIleWriterDemo {
    public static void main(String[] args){
        writer_append();
    }

    public static void writer_test() throws IOException {
        FileWriter fileWriter = new FileWriter("d:\\a.txt");

        fileWriter.write("IO 流你好");

        //数据没有直接写到文件，其实是写到了内存缓冲区
        fileWriter.flush();

        //释放资源
        fileWriter.close();
    }

    public static void flush_close_func(){
        //相对该项目路径
        try {
            FileWriter writer = new FileWriter("a.txt");
            writer.write("hello");
            writer.flush();
            writer.write("world");
            writer.flush();

            //释放资源
            writer.close();
            try {
                writer.write("资源已关闭,不能再写入了");
            } catch (IOException e) {
                System.out.println("---资源已关闭---");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writer_str(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("a.txt");
            String str = "abc";
            writer.write(str + "\n");
            writer.write(str,0,2);
            writer.write( "\n");

            //写一个字符数据,这里写int类型的好处是既可以写char类型的数据，也可以写char对应的int类型的值。'a',97
            writer.write("a" + "\n");
            writer.write(97);

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null){
                try {
                    //释放资源
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    public static void writer_append(){
        try {
            FileWriter writer = new FileWriter("a.txt",true);
            writer.write("\r\n");
            writer.write("world");
            writer.flush();
            //释放资源
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
