package com.foda.java.se.object;

/**
 * 多态的前提：
 * 	子父类的继承关系
 * 	方法的重写
 * 	父类引用指向子类对象
 *
 * 动态绑定：运行期间调用的方法，是根据其具体的类型
 * 多态的成员特点:
 * 		成员变量  编译时看的是左边，运行时看的左边
 * 		成员方法  编译时看的是左边，运行时看右边(方法是被重写的)
 * 		静态方法  编译时看的是左边，运行时看的也是左边
 * 引用类型之间的转换
 *  	向上转型
 *  		由小到大(子类型转换成父类型)
 *  	向下转型
 *  		由大到小
 *  基本数据类型的转换
 *  	自动类型转换
 *  		由小到大
 *  		byte short char --- int --- long --- float --- double
 *  	强制类型转换
 *  		由大到小
 * 多态的优缺点
 * 		优点：可以提高可维护性（多态前提所保证的），提高代码的可扩展性
 *      缺点：无法直接访问子类特有的成员
 * @author pxz
 * @date 2018/11/22 0022-下午 3:34
 */
public class PoymorphicDemo {
    public static void main(String[] args) {
        //父类引用指向子类的实例
        AnimalDemo animal = new CatDemo();
        System.out.println(animal.num);
        animal.eat();

    }
}
class AnimalDemo{
    int num = 10;

    public void eat(){
        System.out.println("吃东西");
    }
}
class CatDemo extends AnimalDemo{
    int num = 20;
    @Override
    public void eat() {
        System.out.println("猫吃东西");
    }
}
