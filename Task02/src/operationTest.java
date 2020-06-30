import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 22:29
 * @Version
 **/
public class operationTest {
    public static void main(String[] args) {
        File file = new File("out.txt");
        BufferedReader br = null;
        FileWriter fw = null;
        FileReader fr = null;
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw = new FileWriter(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                Random x = new Random();
                Random y = new Random();
                Random operator = new Random();
                String s = "";
                int n = operator.nextInt(4);
                //随机生成四种运算符
                if (n == 0) {
                    s = "+";
                } else if (n == 1) {
                    s = "-";
                } else if (n == 2) {
                    s = "*";
                } else {
                    s = "/";
                }
                //随机生成两个随机整数，范围是1-100
                int i1 = x.nextInt(100) + 1;
                int i2 = y.nextInt(100) + 1;
                //创建该表达式的对象
                BinaryFile b = new BinaryFile(i1, i2, s);
                //计算该表达式的结果
                Integer res = b.computers();
                //将最终的结果拼接成算术表达式
                String result = "";
                result += i1;
                result += s;
                result += i2;
                result += "=";
                result += res;
                try {
                    //将算术表达式写入文件
                    if (fw != null) {
                        fw.write(result + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                String data;
                //当文件存在时，则直接输出文件中的内容
                while ((data = br.readLine()) != null) {
                    System.out.println(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    //关闭资源
                    if (fr != null && br != null) {
                        fr.close();
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test() {
        BinaryFile binaryFile = new BinaryFile(1, 1, "/");
        Integer computers = binaryFile.computers();
        System.out.println(computers);
    }
}
