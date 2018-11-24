package com.foda.java.se.set;

import java.util.HashSet;

/**
 * 无序（存储和读取的顺序可能不一样）,不能重复
 * 和新添加的元素进行比较，判断是否重复，如果重复则返回，
 * 先比较hash值，hash值不一样if语句结束
 * 如果hash值一样，则比较地址在或者使用equals方法进行比较
 * 比较结果如果为true，则重复不在添加
 * @author pxz
 * @date 2018/11/22 0022-上午 10:28
 */
public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> strs = new HashSet<String>();
        strs.add("01");
        strs.add("02");
        for (String str : strs) {
            System.out.println(String.format("str is %s",str));
        }
    }
}
