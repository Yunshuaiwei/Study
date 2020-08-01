package ysw;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 9:52
 * @Version
 **/
public class Order<T> {
    String orderName;
    T orderT;
    public Order(){ }
    public Order(String orderName,T orderT){
        this.orderName=orderName;
        this.orderT=orderT;
    }
}
