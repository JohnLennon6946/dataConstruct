package java设计模式.工厂模式.Method;

import java设计模式.工厂模式.Simple.Car;

public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
