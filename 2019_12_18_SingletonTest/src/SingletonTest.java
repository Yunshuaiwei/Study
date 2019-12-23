/**
 * @author DELL
 * @Date 2019/12/18 12:51
 **/
public class SingletonTest {
    public static void main(String[] args) {
        Bank instance1 = Bank.getInstance();
        Bank instance2 = Bank.getInstance();
    }
}

/**
 * 饿汉式
 */
class Bank{
    /**
     * 1、私有化构造器
     */
    private  Bank(){

    }
    /**
     * 2.内部创建类的对象
     */
    private static Bank instance=new Bank();
    /**
     * 3、提供公共的方法，返回类的对象
     */
    public static Bank getInstance(){
        return instance;
    }
}