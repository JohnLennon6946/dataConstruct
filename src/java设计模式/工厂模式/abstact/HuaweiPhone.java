package java设计模式.工厂模式.abstact;

public class HuaweiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("华为手机开机");
    }

    @Override
    public void close() {
        System.out.println("华为手机开机");
    }

    @Override
    public void call() {
        System.out.println("华为打电话");
    }
}
