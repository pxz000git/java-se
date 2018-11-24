package com.foda.java.se.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @author pxz
 * @date 2018/11/22 0022-下午 12:32
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        fileDemo();

    }
    public static void fileDemo() throws IOException {
        File file = new File("e.txt");

        //boolean newFile = file.createNewFile();
        //System.out.println(newFile);

        //boolean delete = file.delete();
        //System.out.println(delete);

        //File absoluteFile = file.getAbsoluteFile();
        //System.out.println(absoluteFile);

        //String absolutePath = file.getAbsolutePath();
        //System.out.println(absolutePath);

        String parent = file.getParent();
        System.out.println(parent);

        String name = file.getName();
        System.out.println(name);

        File parentFile = file.getParentFile();
        System.out.println(parentFile);

        String path = file.getPath();
        System.out.println(path);

        long l = file.lastModified();
        System.out.println(l);

        long length = file.length();
        System.out.println(length);

        // 判断功能
        boolean absolute = file.isAbsolute();
        System.out.println(absolute);

        boolean exists = file.exists();
        System.out.println(exists);

        boolean directory = file.isDirectory();
        System.out.println(directory);

        //修改文件名
        boolean b = file.renameTo(new File("bb.txt"));
        System.out.println(b);


    }
}
