package 高并发.锁的使用;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread(new HoldLockThread(lockA,lockB),"threadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"threadBBB").start();
    }
}
class HoldLockThread implements Runnable{

    private String LockA;
    private String LockB;

    public HoldLockThread(String lockA, String lockB) {
        LockA = lockA;
        LockB = lockB;
    }

    @Override
    public void run() {
        synchronized (LockA){
            System.out.println(Thread.currentThread().getName()+"自己持有"+LockA+"尝试获得"+LockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LockB){
                System.out.println(Thread.currentThread().getName()+"自己持有"+LockB+"尝试获得"+LockA);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//使用jps -l
        //然后使用jstack 线程ID
        /*
    *"threadAAA":
        at 高并发.锁的使用.HoldLockThread.run(DeadLockDemo.java:33)
        - waiting to lock <0x000000008a4bcae0> (a java.lang.String)
        - locked <0x000000008a4bcab0> (a java.lang.String)
        at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)
    "threadBBB":
        at 高并发.锁的使用.HoldLockThread.run(DeadLockDemo.java:33)
        - waiting to lock <0x000000008a4bcab0> (a java.lang.String)
        - locked <0x000000008a4bcae0> (a java.lang.String)
        at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)

Found 1 deadlock.
        *
        * */

    }
}