package 高并发.阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tradition_ProCom {
    public static void main(String[] args) {
        //一个初始值为0，两个线程一个对其+1，一个对其-1
        ShareData shareData=new ShareData();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
    }
}

//资源类
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //多线程操作三板斧：判断，干活，通知
    public void increment() throws Exception {
        //1.判断
        lock.lock();
        try {
            while (number != 0) {   //多线程的判断不能用if，否则存在虚假唤醒问题
                //等待，不能生产
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知，唤醒
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception {
        //1.判断
        lock.lock();
        try {
            while (number == 0) {
                //等待，不能消费
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知，唤醒
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}
