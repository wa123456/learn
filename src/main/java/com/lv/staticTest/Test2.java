package com.lv.staticTest;

public class Test2 {
    Person person = new Person("Test2");
    static{
        System.out.println("test2 static");
    }

    public Test2() {
        System.out.println("test2 constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person constructor"+str);
    }
}


class MyClass extends Test2 {
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}

