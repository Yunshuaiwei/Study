import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author DELL
 * @Date 2020/3/3 15:44
 **/
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取xml文件的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档到内存，获取dom树
        Document parse = Jsoup.parse(new File(path), "utf-8");
        //获取元素对象Element
        Elements from = parse.getElementsByTag("from");
        //获取第一个from的Element对象
        Element element = from.get(0);
        //获取数据
        String text = element.text();
        System.out.println(text);
    }

    @Test
    public void test1() {
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(path, "utf-8");
        System.out.println(parse);
    }

    @Test
    public void test2() throws IOException {
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        Document parse = Jsoup.parse(url, 10000);
        System.out.println(parse);
    }
}
