package com.foda.java.se.list.arraylist;

import java.util.ArrayList;

/**
 * ArrayList 是一个数组队列，相当于 动态数组。与Java中的数组相比，它的容量能动态增长。它继承于AbstractList，实现了List, RandomAccess, Cloneable, java.io.Serializable这些接口。
 * ArrayList 继承了AbstractList，实现了List。它是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
 * ArrayList 实现了RandmoAccess接口，即提供了随机访问功能。RandmoAccess是java中用来被List实现，为List提供快速访问功能的。在ArrayList中，我们即可以通过元素的序号快速获取元素对象；这就是快速随机访问。稍后，我们会比较List的“快速随机访问”和“通过Iterator迭代器访问”的效率。
 * ArrayList 实现了Cloneable接口，即覆盖了函数clone()，能被克隆。
 * ArrayList 实现java.io.Serializable接口，这意味着ArrayList支持序列化，能通过序列化去传输。
 * 和Vector不同，ArrayList中的操作不是线程安全的！所以，建议在单线程中才使用ArrayList，而在多线程中可以选择Vector或者CopyOnWriteArrayLis
 * @author pxz
 * @date 2018/11/21 0021-下午 6:05
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> arrayList = new ArrayList<String>();

        //添加元素
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("Java");

        // 在指定的索引处添加元素
        arrayList.add(1,"addElement");

        System.out.println(String.format("array is %s",arrayList));

        //获取值
        String s = arrayList.get(1);
        System.out.println(String.format("s:%s",s));

        //删除值（true、false）
        boolean remove1 = arrayList.remove("h");
        boolean remove2 = arrayList.remove("hello");
        boolean remove3 = arrayList.remove("hello");
        System.out.println(String.format("remove1 :%s, remove2:%s, remove3:%s",remove1,remove2,remove3));

        //删除值（返回被删除的值）
        String remove = arrayList.remove(1);
        System.out.println(String.format("remove :%s",remove));

        //指定索引位置设置值
        String h = arrayList.set(1, "ha");
        System.out.println(String.format("h :%s",h));

        System.out.println(String.format("arrayList :%s",arrayList));

        //遍历,size():获取列表长度
        for(int i =0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        String[] str = (String[]) arrayList.toArray();
        for (String s1 : str) {
            System.out.println(String.format("s1:%s", s1));
        }



    }

}
