package IOTest;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @ProjectName 2019_10_31
 * @ClassName BufferedTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/1 13:06
 * @Version 1.0
 *
 * 处理流之一：缓冲流
 * 作用：提供流的读写速率
 *      原因：内部提供了一个缓冲区
 *      处理流，就是“套接”在已有的流的基础上。
 **/
public class BufferedTest {
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1、造文件
            File srcFile=new File("2.jpg");
            File desFile=new File("3.jpg");
            //2、造流
            //2.1 造节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(desFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3、复制的细节：读取、写入
            byte[] buffer=new byte[10];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
//                bos.flush();//刷新缓冲区
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源关闭
            //先关闭外层，后关闭内层
            try {
                if(bis!=null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //说明：在关闭外层流的同时，内层流会自动关闭。
//        fis.close();
//        fos.close();
    }

    /**
     * 使用BufferedReader和BufferedWriter实现对文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader bfir= null;
        BufferedWriter bfiw= null;
        try {
            //1、造文件
            File scrfile =new File("hello1");
            File desfile =new File("hello2");
            //2、造流
            FileReader fir=new FileReader(scrfile);
            FileWriter fiw=new FileWriter(desfile);
            //2.1 缓冲流
            bfir = new BufferedReader(fir);
            bfiw = new BufferedWriter(fiw);
            //3 复制文件
            char[] buffer=new char[10];
            int len;
            while((len=bfir.read(buffer))!=-1){
                bfiw.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                if(bfir!=null){
                    bfir.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bfiw!=null){
                    bfiw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testBufferedReaderBufferedWriter2(){
        BufferedReader bf = null;
        BufferedWriter bw= null;
        try {
            //1、创建文件和相应的流
            bf = new BufferedReader(new FileReader(new File("hello")));
            bw = new BufferedWriter(new FileWriter(new File("hello3")));
            //2、读写操作
            //方式一：
            char[] buffer=new char[10];
            int len;
            while((len=bf.read(buffer))!=-1){
                bw.write(buffer,0,len);
            }
            //方式二：readLine()：一次读一行
            String data;
            while((data=bf.readLine())!=null){
                //方法一：
//                bw.write(data);//data中不包含换行符
                //方法二：
                bw.write(data);
                bw.newLine();//提供换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //3、关闭资源
                if(bf!=null){
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bw!=null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
