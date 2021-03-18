package java设计模式.工厂模式.abstact;

public class XiaomiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void close() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void call() {
        System.out.println("用小米手机打电话");
    }
}
