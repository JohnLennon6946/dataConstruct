package java设计模式.代理模式.静态代理.demo02;

public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public UserServiceProxy() {
    }

    public UserServiceProxy(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        setLog("add");
        userService.add();
    }

    @Override
    public void delete() {
        setLog("delete");
        userService.delete();
    }

    @Override
    public void update() {
        setLog("update");
        userService.update();
    }

    @Override
    public void query() {
        setLog("query");
        userService.query();
    }

    //日志方法
    public void setLog(String msg){
        System.out.println("执行了"+msg+"方法");
    }

}
