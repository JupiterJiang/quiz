package Singleton;

/**
 * 单例设计模式：保证类在内存中只有一个对象
 *
 * @author zhenshan
 */
public class Singleton {

    public static void main(String[] args) {

        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s1 == s2);
    }
}

//饿汉
class Singleton1 {

    //1,私有构造方法,其他类不能访问该构造方法
    private Singleton1() {}
    
    //2，创建本类对象
    private static Singleton1 s = new Singleton1();

    //3，对外提供公共的访问方法
    public static Singleton1 getInstance() {
        return s;
    }
}


//懒汉
class Singleton2{
    private  Singleton2(){}
    
    private static Singleton2 s;
    
    public static Singleton2 getInstance(){
        if (s==null) {
            s = new Singleton2();
        }
        return s;
    }
}