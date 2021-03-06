package 数据结构.线性结构.队列;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue aq=new ArrayQueue(3);
        char key=' '; //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):获取队列头的数据");
            key=scanner.next().charAt(0); //接受一个字符
            switch (key){
                case 's':
                    aq.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                case 'a':
                    System.out.println("=====请输入一个数据=====");
                    int value=scanner.nextInt();
                    aq.addQueue(value);
                    break;
                case 'g':
                    try {
                        int push=aq.pushQueue();
                        System.out.println("取出了数据"+push);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int head = aq.headQueue();
                        System.out.println("队列头部为"+head);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("》》》》》》》》》》程序退出");

    }
}

//编写一个类，使用数组模拟队列
class ArrayQueue{
    private int maxsize;//表示数组最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr;  //该数组用于存放数据，模拟队列

    //创建队列，构造器
    public ArrayQueue(int maxsize){
        this.maxsize=maxsize;
        arr=new int[maxsize];
        front=-1;  //指向队列头部,front是指向队列头的前一个位置
        rear=-1;    //指向队列尾部，指向队列具体数据
    }
    //判断队列书否满
    public boolean isFull(){
        return rear==maxsize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满不能加入数据");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //数据出队列
    public int pushQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空不能取数据");
        }
        front++;  //front后移
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头部，注意不是取出数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列为空,无法取出数据");
        }
        return arr[front+1];
    }
}

//目前数组使用一次就不能使用了，没有达到复用的作用
//下一步要使用算法该进成环形队列，使用取模的方式
//front变量的含义做出调整，front指向第一个元素
//front和rear的初始值都是0
//rear变量指向最后一个元素的后一个位置，空出一个空间作为约定
//所以当队列满时 条件是(rear+1)%maxsize=front【满】
//队列为空的条件没变