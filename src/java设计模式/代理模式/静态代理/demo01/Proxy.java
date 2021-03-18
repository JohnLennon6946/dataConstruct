package java设计模式.代理模式.静态代理.demo01;

//代理角色,代理房东
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override   //代理帮房东租房子
    public void rent() {
        seeHouse();
        host.rent();
        fare();
        //设计模式为代理模式
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
