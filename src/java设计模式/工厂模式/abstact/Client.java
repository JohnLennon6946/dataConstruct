package java设计模式.工厂模式.abstact;

public class Client {
    public static void main(String[] args) {
        System.out.println("小米系列产品************");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IPhoneProduct xiaomi = xiaomiFactory.iPhoneProduct();
        xiaomi.call();

        System.out.println();

        System.out.println("华为系列产品*************");
        HuaweiFactory huaweiFactory=new HuaweiFactory();
        RouterProduct huawei = huaweiFactory.routerProduct();
        huawei.setting();
    }
}
