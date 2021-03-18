package java设计模式.单例模式;

public class SingletonDemo {
    public static void main(String[] args) {
        //单例模式，保证一个类只有一个实例，并且提供一个全局访问点
        //只能new一个实例,把该类的构造方法私有化
        //new Single01();因为构造方法是私有的，所以不能new
        Single01 single01=Single01.getInstance();
        System.out.println(single01.m());

        Single02 single02=Single02.getInstance();
        single02.m();

    }
}
