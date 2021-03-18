package java设计模式.工厂模式.abstact;

//抽象产品工厂
public interface AbstactFactory {
    //生产手机和路由器
    IPhoneProduct iPhoneProduct();

    RouterProduct routerProduct();
}
