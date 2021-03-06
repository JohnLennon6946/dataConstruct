package 数据结构.线性结构.队列;

import java.util.Scanner;

public class CircleArrQueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列");
        //创建一个队列
        CircleArrQueue caq=new CircleArrQueue(4);  //这里设置4，队列有效最大为3
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
                    caq.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                case 'a':
                    System.out.println("=====请输入一个数据=====");
                    int value=scanner.nextInt();
                    caq.addQueue(value);
                    break;
                case 'g':
                    try {
                        int push=caq.pushQueue();
                        System.out.println("取出了数据"+push);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int head = caq.headQueue();
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
class CircleArrQueue{
    private int arrMaxSize;//表示数组最大容量
    //front变量的含义做出调整，front指向第一个元素
    //front和rear的初始值都是0
    private int front; //队列头
    //rear变量指向最后一个元素的后一个位置，空出一个空间作为约定
    private int rear; //队列尾
    private int[] arr;  //该数组用于存放数据，模拟队列

    public CircleArrQueue(int arrMaxSize){
        this.arrMaxSize=arrMaxSize;
        arr=new int[arrMaxSize];
        front=0;
        rear=0;
    }
    //判断队列书否满
    public boolean isFull(){
        return (rear+1)%arrMaxSize==front;
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
        arr[rear]=n;   //此时rear就是指向最后一个数据的
        //将rear后移
        rear=(rear+1)%arrMaxSize;
    }
    //数据出队列
    public int pushQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空不能取数据");
        }
        int temp=arr[front];  //这里front是指向第一个位置的
        front=(front+1)%arrMaxSize;
        return temp;
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        //从front开始遍历，遍历多少个元素
        for (int i = front; i <front+size() ; i++) {
            System.out.printf("arr[%d]=%d\n",i%arrMaxSize,arr[i%arrMaxSize]);
        }
    }
    //求出当前队列有效数据数量
    public int size(){
        return (rear+arrMaxSize-front)%arrMaxSize;
    }
    //显示队列的头部，注意不是取出数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列为空,无法取出数据");
        }
        return arr[front];
    }
}