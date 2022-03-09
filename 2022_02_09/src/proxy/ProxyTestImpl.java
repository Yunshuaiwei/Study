package proxy;

/**
 * @author yunshuaiwei
 * @className ProxyTestImpl
 * @description: TODO
 * @date 2022/3/9 10:37
 */
public class ProxyTestImpl implements ProxyTest{
    @Override
    public void buyGoods(int money) {
        System.out.println("购买商品，金额："+money);
    }

    @Override
    public void afterSale(int money) {
        System.out.println("售后价格："+money);
    }
}
