package java设计模式.单例模式;
//双重检查机制
public class Single05 {
    private static Single05 INSTANCE;  //这里不能加final，因为final必须要初始化

    private Single05(){};

    //在if里面代码块加锁，这样还是无法实现线程安全
    public static Single05 getInstance(){
        if(INSTANCE==null){
            synchronized (Single04.class){
                if (INSTANCE==null){
                    try{
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE=new Single05();
                }
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
                System.out.println(Single05.getInstance().hashCode());
            }).start();
        }
    }
}
