import java.io.*;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/4/11 21:08
 * @Version
 **/
public class Test {
    @org.junit.Test
    public void test() throws Exception {
        FileInputStream fis = new FileInputStream(new File("data.txt"));
        BufferedReader b = new BufferedReader(new InputStreamReader(fis, "utf-8"));
        String line;
        while((line=b.readLine())!=null){
            System.out.println(line);
        }
    }
    @org.junit.Test
    public void writeTest() throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("data.txt"));
        BufferedWriter b = new BufferedWriter(new OutputStreamWriter(fos));
        b.write("1:yushahfdhakjh\n");
        b.write("1:yushahfdhakjh\n");
        b.flush();
    }
}
