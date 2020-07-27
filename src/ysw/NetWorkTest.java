package ysw;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/27 22:34
 * @Version
 **/
public class NetWorkTest {
    public static void main(String[] args) {
        Server server=new Server();
        //传入被代理类对象，即多态的使用
        ProxyServer proxyServer=new ProxyServer(server);
        //代码层面看到的是调用代理类中的browse，实际调用的为被代理类中的browse方法
        proxyServer.browse();
    }
}
interface NetWork{
    public void browse();
}
//被代理类
class Server implements NetWork{

    @Override
    public void browse() {
        System.out.println("服务器访问网络！！！");
    }
}
//代理类
class ProxyServer implements NetWork{
    private NetWork netWork;
    public ProxyServer(NetWork netWork){
        this.netWork=netWork;
    }
    public void check(){
        System.out.println("联网之前的检查工作！！！");
    }
    @Override
    public void browse() {
        //在代理类中可以增加其他的业务逻辑
        check();
        netWork.browse();
    }
}