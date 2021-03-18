package java设计模式.单例模式;

import java.util.concurrent.TimeUnit;

//懒汉式,什么时候用的时候，什么时候才将它初始化
//但是多线程访问的时候时会有影响
public class Single02 {
    private static Single02 INSTANCE;  //这里不能加final，因为final必须要初始化

    private Single02(){};

    public static Single02 getInstance(){
        if(INSTANCE==null){   //多线程访问的时候，可能多次进入这个if，因为其他线程还没来得及初始化
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Single02();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("我是懒汉式单例模式");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Single02.getInstance().hashCode());
            }).start();
        }
    }
}
