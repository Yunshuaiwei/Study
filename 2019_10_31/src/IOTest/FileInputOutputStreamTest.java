package IOTest;

import org.junit.Test;

import java.io.*;

/**
 * @ProjectName 2019_10_31
 * @ClassName IOTest.FileInputOutputStreamTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/1 10:43
 * @Version 1.0
 *
 *
 * 结论：对于文本文件（.txt,.java,.c.cpp），使用字符流处理
 *       对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)使用字节流处理
 **/
public class FileInputOutputStreamTest {
    //使用字节流处理文本文件可能出现乱码
    @Test
    public void teatFileInputStream() {
        //1、创建文件
        File file=new File("hello");
        FileInputStream fis= null;
        try {
            //2、创建输入流
            fis = new FileInputStream(file);
            //3、读入数据
            byte[] buffer=new byte[5];
            int len;//记录每次读取的字节的个数
            while((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null){
                    //4、关闭资源
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //实现对图片的复制操作
    @Test
    public void testFileInputOutputStream() {
        //创建文件
        File srcFile=new File("2.jpg");
        File desFile=new File("3.jpg");
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            //创建流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            //复制的过程
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos!=null){
                    //关闭流
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
