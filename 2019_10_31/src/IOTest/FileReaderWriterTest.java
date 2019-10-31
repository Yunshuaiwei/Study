package IOTest;

import org.junit.Test;

import java.io.*;

/**
 * @ProjectName 2019_10_31
 * @ClassName FileReaderWriterTest
 * Description
 * @Auther YunSW
 * @Date 2019/10/31 11:38
 * @Version 1.0
 **/
public class FileReaderWriterTest {
    public static void main(String[] args) throws IOException {
        File file=new File("hello");
        System.out.println(file.getAbsolutePath());
//        FileReaderWriterTest test =new FileReaderWriterTest();
//        test.testFileReader();
    }

    /**
     * 将hello文件的内容读入程序中，并输出到控制台
     */
    @Test
    public void testFileReader() {
        //1、实例化File类的对象，指明要操作的文件
        File file=new File("hello");
        //2、提供具体的流
        FileReader fr= null;
        try {
            fr = new FileReader(file);
            //数据的读入
            //read()：返回读入的字符。如果到达文件的末尾则返回-1；
            int data;
            while((data=fr.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭
            try {
                //当fr = new FileReader(file);出现异常时，可能会导致没有造好对象，有可能导致空指针
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testFileReader1(){
        //1、Lile类的实例化
        File file=new File("hello");
        //2、FileReader流的实例化
        FileReader fr=null;
        try {
            fr=new FileReader(file);
            //3、读入操作
            //read(char[] tmp):返回每次读入tmp数组中的字符的个数。如果达到文件末尾返回-1.
            char [] tmp=new char[5];
            int len;
            while((len=fr.read(tmp))!=-1){
                //方式一：
                //错误写法
//                for (int i = 0; i <tmp.length ; i++) {
//                    System.out.print(tmp[i]);
//                }
                //正确写法
//                for (int i = 0; i <len ; i++) {
//                    System.out.print(tmp[i]);
//                }
                //方式二：
                //错误写法，
//                String str=new String(tmp);
//                System.out.print(str);
                //正确写法
                String str=new String(tmp,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //3、资源的关闭
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从内存中写出数据到硬盘中去。
     */
    @Test
    public void testFileWriter()  {
        //1、提供File类的对象，指明写出到的文件
        File file=new File("helloworld");
        FileWriter fw=null;
        try {
            //2、提供FileWriter的对象，用于数据的写出
            fw=new FileWriter(file);

            //3、写出
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testFileReaderWriter() {
        //1、创建File类的对象，指明读入和写出的文件
        File srcFile=new File("helloworld");
        File desFile=new File("hello1");
        FileReader fr= null;
        FileWriter fw= null;
        try {
            //2、创建输入和输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile);
            //3、数据的读入和写出操作
            char [] cbuf=new char[5];
            int len;
            while((len=fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4、关闭流资源
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
