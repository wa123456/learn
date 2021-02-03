package com.lv.test;


import java.util.Scanner;

/**
 * @program: learnning
 * @description: 简单数组模拟队列,暂时，这个都是指向-1
 * @author: Lv
 * @create: 2020-08-06 15:00
 **/
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQuene queue = new ArrayQuene(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();

                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;

                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                    /*
                default:
                    break;
                    */
            }
        }

        System.out.println("程序退出~~");
    }

}

/**
 * @program: learnning
 * @description: 初始化数组
 **/
class ArrayQuene{
    private int [] arr;
    private int front = 0;
    private int rear = 0;
    private int maxSize = 0;

    public ArrayQuene(){}

    public  ArrayQuene(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void showQueue() {
        for (int i = front%maxSize; i < front%maxSize+ size()  ; i++) {
            System.out.println("arr["+i+"] = " + arr[i%maxSize]);
        }
    }

    public int size(){
        //这个加maxSize还是很有必要的，不加的话 rear不一定比front大
        return(rear+maxSize-front)%maxSize;
    }
    public void addQueue(int value) {
        if(isFull()){
            System.out.println("数据已满，不能再加入数据~");
            return;
        }

        arr[rear] = value;
        rear = (rear +1)%maxSize;

    }

    public int getQueue() {
        if(isEmpty()){
            System.out.println("数据已满，不能再加入数据~");
            throw new RuntimeException("队列为空，不能取数据！");
        }
        int temp = arr[front];
        front = (front+1)%maxSize;
        return temp;
    }

    public int headQueue() {
        return arr[front];
    }

    public boolean isFull(){
        return (rear ) % maxSize  == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

}

