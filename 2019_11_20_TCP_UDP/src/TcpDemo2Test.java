import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author DELL
 * @Date 2019/11/21 10:09
 **/
public class TcpDemo2Test {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream ops = null;
        FileInputStream fis = null;
        try {
            //1、创建socket
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
            //2、获取输出流
            ops = socket.getOutputStream();
            //3、文件输入流
            fis = new FileInputStream(new File("房东的猫5.jpg"));
            //4、读入数据
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                ops.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();
            //5、接受来自服务端的数据，并显示在控制台
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            byte[] buff=new byte[5];
            int len1;
            while((len1=is.read(buff))!=-1){
                bs.write(buff,0,len1);
            }
            System.out.println(bs.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //5、关闭流
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ops!=null){
                    ops.close();
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
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //1、创建ServerSocket
            serverSocket = new ServerSocket(8899);
            //2、获取客户端socket
            accept = serverSocket.accept();
            //3、客户端输入流
            is = accept.getInputStream();
            //4、保存文件到本地
            fos = new FileOutputStream(new File("1.jpg"));
            //5、将文件写入本地
            byte [] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            //6、服务器向客户端回数据
            OutputStream os = accept.getOutputStream();
            os.write("图片收到！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6、流关闭
            if(fos!=null){
                fos.close();
            }
            if(is!=null){
                is.close();
            }
            if(accept!=null){
                accept.close();
            }
            if(serverSocket!=null){
                serverSocket.close();
            }
        }
    }
}
