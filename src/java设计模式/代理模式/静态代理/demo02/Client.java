package java设计模式.代理模式.静态代理.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        UserServiceProxy userProxy=new UserServiceProxy(userService);
        //纯静态代理
        userProxy.add();
    }
}
