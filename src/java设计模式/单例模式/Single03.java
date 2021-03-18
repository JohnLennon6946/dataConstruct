package java设计模式.单例模式;

import java.util.concurrent.TimeUnit;

public class Single03 {
    private static Single03 INSTANCE;  //这里不能加final，因为final必须要初始化

    private Single03(){};

    //加锁可以解决多线程下单例模式的问题，但是会极大降低效率
    public static synchronized Single03 getInstance(){
        if(INSTANCE==null){   //多线程访问的时候，可能多次进入这个if，因为其他线程还没来得及初始化
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Single03();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("我是懒汉式单例模式");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Single03.getInstance().hashCode());
            }).start();
        }
    }
}
