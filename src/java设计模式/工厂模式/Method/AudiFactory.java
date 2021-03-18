package java设计模式.工厂模式.Method;

import java设计模式.工厂模式.Simple.Car;

public class AudiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
