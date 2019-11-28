import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author DELL
 */
public class UdpDemo1Test {
    /**
     * 发送端
     */
    @Test
    public void sender() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            String str="hello";
            byte[] bs = str.getBytes();
            InetAddress ip = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(bs, 0, bs.length, ip, 9999);
            ds.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ds!=null){
                ds.close();
            }
        }
    }
    /**
     * 接收端
     */
    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9999);
            byte[] buffer=new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
}
