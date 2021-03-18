package java设计模式.工厂模式.abstact;

public class HuaweiFactory implements AbstactFactory{
    @Override
    public IPhoneProduct iPhoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
