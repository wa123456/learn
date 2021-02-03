package com.lv.staticTest.staticTest;


public class StaticTest {
    public static void main(String[] args) {
        A3 a3 = new A3();
    }
}

class A3{
    B3 b3 = new B3();
    static C3 c4 = new C3();
    static{
        System.out.println("A3");
    }
}

class B3{
    static{
        System.out.println("B3");
    }
}

class C3{
    static{
        System.out.println("C3");
    }
}
