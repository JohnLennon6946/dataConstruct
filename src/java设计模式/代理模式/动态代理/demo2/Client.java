package java设计模式.代理模式.动态代理.demo2;

import java设计模式.代理模式.静态代理.demo02.UserService;
import java设计模式.代理模式.静态代理.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ProxyInvocationHandler invocationHandler=new ProxyInvocationHandler();
        invocationHandler.setTarget(userService);
        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.delete();
    }
}
