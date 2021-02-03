package com.lv.staticTest;


public class ExtendTest {
    public static void main(String[] args) {
        C c = new C();
    }
}

class A{
    static{
        System.out.println("A static");
    }
}

class B extends A{
    /*
    B (){
        System.out.println("c  construct"  );
    }
    */
    static{
        System.out.println("B static");
    }
}

class C extends B{
    C (){
        System.out.println("c  construct"  );
    }


    private  D d = new D();
    static{
        System.out.println("C static");
    }
}

class D{
    static{
        System.out.println("D static");
    }
}

