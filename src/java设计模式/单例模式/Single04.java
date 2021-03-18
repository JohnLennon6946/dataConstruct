package java设计模式.单例模式;

public class Single04 {
    private static Single04 INSTANCE;  //这里不能加final，因为final必须要初始化

    private Single04(){};

    //在if里面代码块加锁，这样还是无法实现线程安全
    public static Single04 getInstance(){
        if(INSTANCE==null){
            //试图通过减小同步代码块的方式提高效率,只加在需要的时候
            //可以有多个线程进入if，其中一个线程得到锁之后，
            // 会实例化一个对象，之后会释放锁，其他进入了if的线程又会重复这个过程，
            // 创建新的实例
            synchronized (Single04.class){
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE=new Single04();
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("我是懒汉式单例模式");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Single04.getInstance().hashCode());
            }).start();
        }
    }
}
