package com.foda.java.se.object.PackagePermissions;

/**
 * 权限修饰符：
 *      public 当前类，相同包下不同的类,不同包下的类
 *      default 当前类，相同包下不同的类
 *      private 当前类
 *      protected 当前类，相同包下不同的类
 *
 * default:当前包下使用
 * protected:让子类对象使用
 * @author pxz
 * @date 2018/11/22 0022-下午 4:17
 */
public class PermissionsDemo {

    public void publicMethod() {
        System.out.println("publicMethod");
    }

    void defaultMethod() {
        System.out.println("defaultMethod");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    public static void main(String[] args) {
        PermissionsDemo pd = new PermissionsDemo();
        pd.publicMethod();
        pd.defaultMethod();
        pd.privateMethod();
        pd.protectedMethod();
    }
}
