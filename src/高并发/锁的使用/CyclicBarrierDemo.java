package 高并发.锁的使用;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//屏障，加计数器，直到线程完成数到达屏障才停止阻塞。
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <=7; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"收集龙珠"+String.valueOf(i)).start();
        }
    }
}
