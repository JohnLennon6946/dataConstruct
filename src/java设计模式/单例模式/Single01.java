package java设计模式.单例模式;

//类加载到内存后，就实例化一个单例，JVM保证线程安全
//但是会还没使用的时候就初始化了一个实例，这叫饿汉式
//多数情况下，推荐使用
public class Single01 {
    private static final Single01 INSTANSE =new Single01();

    private Single01(){};

    public static Single01 getInstance(){
        return INSTANSE;
    }
    public String m(){
        return "调用了单例模式";
    }

    public static void main(String[] args) {
        Single01 s1=Single01.getInstance();
        Single01 s2=Single01.getInstance();
        System.out.println(s1==s2);
    }
}
