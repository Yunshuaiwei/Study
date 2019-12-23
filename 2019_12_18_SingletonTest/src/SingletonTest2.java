/**
 * @author DELL
 * @Date 2019/12/18 12:58
 **/
public class SingletonTest2 {
    public static void main(String[] args) {
        Bank instance = Bank.getInstance();
    }
}

/**
 * 懒汉式
 */
class Order{
    /**
     * 1、私有化类的构造器
     */
    private Order(){

    }
    /**
     * 2、声明当前类的对象，没有初始化
     */
    private static Order instance=null;

    /**
     * 3、声明public、static的返回当前类的对象
     * @return
     */
    public static Order getInstance(){
        if(instance==null){
            instance=new Order();
        }
        return instance;
    }
}