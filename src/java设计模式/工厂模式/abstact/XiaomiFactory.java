package java设计模式.工厂模式.abstact;

public class XiaomiFactory implements AbstactFactory{
    @Override
    public IPhoneProduct iPhoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
