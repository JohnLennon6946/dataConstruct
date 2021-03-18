package java设计模式.单例模式;
//静态内部类的完美写法,JVM保证线程安全，因为JVM类加载器加载一个class只加载一次
public class Single06 {
    private Single06(){};

    //静态内部类,外面的类被加载的时候，里面的类是不会被加载的
    private static class Single06Holder{
        private final static Single06 INSTANCE=new Single06();
    }

    public static Single06 getInstance(){
        return Single06Holder.INSTANCE;
    }
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Single06.getInstance().hashCode());
            }).start();
        }
    }
}
