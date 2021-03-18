package 高并发.锁的使用;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //信号灯，多个线程抢多个资源，加减伸缩
        //信号量用于第一是共享资源互斥使用，第二个是用于并发线程数控制
        Semaphore semaphore=new Semaphore(3);   //有三个车位
        for (int i = 1; i <=6 ; i++) {   //有6辆车
            new Thread(()->{
                try {
                    semaphore.acquire();   //获取到锁
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放锁
                }
            },String.valueOf(i)).start();
        }
    }
}
