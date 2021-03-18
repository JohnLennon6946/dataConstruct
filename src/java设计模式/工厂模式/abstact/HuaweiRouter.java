package java设计模式.工厂模式.abstact;

public class HuaweiRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("华为路由器开机");
    }

    @Override
    public void close() {
        System.out.println("华为路由器关机");
    }

    @Override
    public void openWifi() {
        System.out.println("华为路由器连wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");
    }
}
