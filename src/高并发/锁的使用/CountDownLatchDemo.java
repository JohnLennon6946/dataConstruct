package 高并发.锁的使用;

import 高并发.锁的使用.Utils.SixCountryEnum;

import java.util.concurrent.CountDownLatch;
//减计数器，让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 国被灭");
                countDownLatch.countDown();
            }, SixCountryEnum.forEach_Country(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"   秦灭六国一统中华");
    }
}
