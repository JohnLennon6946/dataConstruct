package java设计模式.工厂模式.Simple;

public class CarFactory {
    //方法一
    public static Car getCar(String name){
        if(name.equals("宝马")){
            return new BMW();
        }else if(name.equals("特斯拉")){
            return new Tesla();
        }
        return null;
    }
    //方法二
    public static Car getBMW(){
        return new BMW();
    }
    public static Car getTesla(){
        return new Tesla();
    }
}
