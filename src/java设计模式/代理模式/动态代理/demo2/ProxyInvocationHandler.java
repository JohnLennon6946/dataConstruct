package java设计模式.代理模式.动态代理.demo2;

import java设计模式.代理模式.静态代理.demo02.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    //需要代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object invoke=method.invoke(target,args);
        return invoke;
    }

    public void log(String msg){
        System.out.println("调用了"+msg+"方法");
    }
}
