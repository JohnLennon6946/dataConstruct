package java设计模式.工厂模式.Simple;

public class Consumer {
    public static void main(String[] args) {
//        Car car=new BMW();
//        Car car1=new Tesla();
//        car.name();
//        car1.name();

        CarFactory carFactory=new CarFactory();
        Car car2 = carFactory.getCar("宝马");
        car2.name();
    }
}
