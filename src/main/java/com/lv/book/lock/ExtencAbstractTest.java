package com.lv.book.lock;

/**
 * @program: learnning
 * @description: 抽象类继承测试
 *
 *
 * @author: Lv
 * @create: 2020-06-04 11:24
 **/
public class ExtencAbstractTest extends Father{
    //Class 'ExtencAbstractTest' must either be declared abstract or implement abstract method 'test4()' in 'Father'
    //如果父类抽象类中有absract修饰的抽象方法，那么子类必须实现该抽象方法，否则子类也必须是抽象类；
    protected int tryAcquire(int arg){
        System.out.println("son tryAcquir");
        return 1;
    }

    public static void main(String[] args) {
        ExtencAbstractTest son = new ExtencAbstractTest();
        //son.acquire(1);
        son.test3();
    }
}


abstract class Father{
    Father(){}
    protected int tryAcquire(int arg){
        throw new RuntimeException();
    }
    /*
    abstract void test4();
    */
    public final void acquire(int arg) {
        //经测试，父类确实在此处调用了子类重写的方法，而没有调用父类自己已经被重写的方法；
        tryAcquire(arg);
    }

    public static void test3(){
        System.out.println("我是抽象类的静态方法 ");
    }


    /***
     * abstract 关键字，和哪些关键字不能共存。（final private static三种不能同abstract一块用）
     * 28 final：被final修饰的类不能有子类（不能被继承http://www.cnblogs.com/itcqx/p/5541659.html）。而被abstract修饰的类一定是一个父类（需要被继承才能使用）。所　　　　　　以不能共存
     * 29 private: 抽象类中的私有的抽象方法，不被子类所知，就无法被复写。
     * 30         而抽象方法出现的就是需要被复写。所以不能共存
     * 31 static：如果static可以修饰抽象方法，那么连对象都省了，直接类名调用就可以了。
     * 32         可是抽象方法运行没意义。所以不能类名.抽象方法，所以直接不能跟static共存
     * 33
     * 34
     * 36 　　抽象类中是否有构造函数？
     * 37 　　　　有，抽象类是一个父类，要给子类提供实例的初始化。所以存在构造函数
     */
}


