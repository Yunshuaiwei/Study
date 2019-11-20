import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther
 * @Date 2019/11/20 19:55
 **/
public class TCPDemo1 {
    /**
     * 客户端
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream out = null;
        try {
            //1、创建Socket对象，指明服务器端的ip和端口号
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            socket = new Socket(byName,8888);
            //2、获取输出流，用于输出
            out = socket.getOutputStream();
            //3、写出数据
            out.write("你好！我是客户端！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4、资源关闭
                if(out!=null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 服务端
     */
    @Test
    public void server(){
        ServerSocket ss =null;
        ByteArrayOutputStream bs =null;
        InputStream is =null;
        try {
            //1、创建服务器的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8888);
            //2、调用accept()表示接受来自于客户端的socket
            Socket socket = ss.accept();
            //3、获取输入流
            is = socket.getInputStream();
            //4、读取输入流中的数据
            bs = new ByteArrayOutputStream();
            byte[] buffer=new byte[5];
            int len;
            while((len=is.read(buffer))!=-1){
                bs.write(buffer,0,len);
            }
            System.out.println(bs.toString());
            System.out.println("收到来自于"+socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //5、关闭流
                if(ss!=null){
                    ss.close();
                }
                if(bs!=null){
                    bs.close();
                }
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
