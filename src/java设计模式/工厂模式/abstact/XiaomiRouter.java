package java设计模式.工厂模式.abstact;

public class XiaomiRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("小米路由器开机");
    }

    @Override
    public void close() {
        System.out.println("小米路由器关机");
    }

    @Override
    public void openWifi() {
        System.out.println("小米路由器连wifi");
    }

    @Override
    public void setting() {
        System.out.println("小米路由器设置");
    }
}
