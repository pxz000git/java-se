package com.foda.java.se.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Collection和Collections有什么区别？
 *Collection是集合体系的最顶层，包含了集合体系的共性
 *Collections是一个工具类，方法都是用于操作Collection
 * @author pxz
 * @date 2018/11/22 0022-上午 10:34
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        //swap(),将指定列表中的两个索引进行位置互换
        System.out.println(list);
        Collections.swap(list,0,1);
        System.out.println(list);

        binary_search_func();
    }

    public static void func(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //安照列表中元素的自然顺序排序
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        //随机置换
        Collections.shuffle(list);

        //反转
        Collections.reverse(list);

    }
    public static void fill_func(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");

        //使用指定的对象填充指定的列表的所有元素
        System.out.println(list);
        Collections.fill(list,"android");
        //[android, android, android]
        System.out.println(list);


    }

    public static void copy_func() {
        // copy() 把源列表中的数据覆盖到目标列表
        // 注意，目标列表的长度至少等于源列表的长度
        //创建源列表
        List<String> src = new ArrayList<String>();
        src.add("hello");
        src.add("world");
        src.add("java");
        //创建目标列表
        List<String> dest = new ArrayList<String>();
        dest.add("java");
        dest.add("java");
        dest.add("java");
        dest.add("java");

        Collections.copy(dest,src);
        System.out.println(dest);


    }

    public static void binary_search_func() {
        // 使用二分法查找指定元素在指定列表的索引位置
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int index = Collections.binarySearch(list, 4);
        System.out.println(String.format("index is %s, element is %s",index,list.get(index)));
    }


}
