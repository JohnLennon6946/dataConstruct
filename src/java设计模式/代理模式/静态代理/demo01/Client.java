package java设计模式.代理模式.静态代理.demo01;

public class Client {
    public static void main(String[] args) {
//        Host host=new Host();
//        host.rent();
        Host host=new Host();
        //代理者代理房东，中介帮房东出租房子，但是代理一般还有一些附属操作
        Proxy proxy=new Proxy(host);
        //通过代理租房屋，不用面对房东
        proxy.rent();

    }
}
