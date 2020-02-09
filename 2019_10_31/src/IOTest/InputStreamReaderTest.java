package IOTest;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @ProjectName 2019_10_31
 * @ClassName InputStreamReader
 * Description
 * @Auther YunSW
 * @Date 2019/11/4 10:18
 * @Version 1.0
 *
 * 处理流二：转换流：属于字符流
 *      InputStreamReader：将一个字节的输入流转换为字符的书输入流
 *      OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 * 作用：提供字节流与字节流的相互转换
 *3、解码：字节、字节数组----->字符数组、字符串
 *   编码：字符数组、字符串---->字节、字节数组
 *4、字符集：
 **/
public class InputStreamReaderTest {
    @Test
    public void test1() {
        InputStreamReader isr= null;
        try {
            FileInputStream fis=new FileInputStream("hello1");
            isr = new InputStreamReader(fis,"UTF-8");//默认为文件保存时的字符集

            char [] cbuf=new char[5];
            int len;
            while((len=isr.read(cbuf))!=-1){
                String str=new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void teat2(){
        //1、造文件、造流
        File file1=new File("hello1");
        File file2=new File("hello_gbk");
        InputStreamReader isr= null;
        OutputStreamWriter osw= null;
        try {
            FileInputStream fis=new FileInputStream(file1);
            FileOutputStream fos=new FileOutputStream(file2);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");
            //2、读写过程
            char[] cbuf=new char[5];
            int len;
            while((len=isr.read(cbuf))!=-1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3、资源关闭
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(osw!=null){
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
