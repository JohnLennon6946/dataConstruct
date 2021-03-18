package java设计模式.代理模式.动态代理;

//房东
public class Host implements Rent {

    @Override
    public void rent() {

        System.out.println("房东要出租房子");
    }
}
