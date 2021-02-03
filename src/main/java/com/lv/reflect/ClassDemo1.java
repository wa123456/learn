package com.lv.reflect;

public class ClassDemo1 {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Class c1 = Foo.class;
        Class c2 = foo.getClass();
        System.out.println(c1 == c2);

        Class c3 = null;
        try {
            c3 = Class.forName("com.lv.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c2 == c3);
        Foo foo2 = null;
        try {
            foo2 = (Foo)c1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        foo2.print();
    }
}

class Foo{
    void print(){
        System.out.println("Foo!!!!");
    }

}

