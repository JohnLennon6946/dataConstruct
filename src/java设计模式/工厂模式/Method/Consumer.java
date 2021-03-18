package java设计模式.工厂模式.Method;

import java设计模式.工厂模式.Simple.Car;

//这里使用工厂方法模式
public class Consumer {
    public static void main(String[] args) {
        Car car = new BWMFactory().getCar();
        car.name();

        Car car1=new AudiFactory().getCar();
        car1.name();
    }
}
