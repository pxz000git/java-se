package com.foda.java.se.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author pxz
 * @date 2018/11/21 0021-下午 6:45
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();

        //添加(key,value)
        map.put("01","张三");
        map.put("02","李四");
        map.put("03","王五");

        //清空所有的对应关系
        //map.clear();
        //System.out.println(map);

        //指定的key删除对应关系，并返回key所对应的值，如果没有删除成功，返回null
        String s = map.remove("01");
        System.out.println(s);

        //判断是否存在
        boolean b = map.containsKey("01");
        boolean b1 = map.containsValue("张三");
        System.out.println(String.format("b:%s, b1:%s",b,b1));

        //判断是否为空
        boolean empty = map.isEmpty();
        System.out.println(empty);

        //返回对应关系的个数
        int size = map.size();
        System.out.println(size);

        //根据指定的key返回value
        String s1 = map.get("01");
        System.out.println(s1);

        //返回键的集合
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(String.format("key is %s",key));
        }

        //返回值的集合
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(String.format("value is %s",value));
        }

        //返回键值对的集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(String.format("key is %s, value is %s",key,value));
        }


    }

}
