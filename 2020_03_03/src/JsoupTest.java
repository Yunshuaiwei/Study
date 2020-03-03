import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author DELL
 * @Date 2020/3/3 17:04
 **/
public class JsoupTest {
    @Test
    public void test() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        //获取所有heading对象
        Elements heading = parse.getElementsByTag("heading");
        System.out.println(heading);
    }

    @Test
    public void test2() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        //获取属性名为id的元素对象
        Elements id = parse.getElementsByAttribute("id");
        System.out.println(id);
    }

    @Test
    public void test3() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        //获取属性名为number值为1的元素对象
        Elements id = parse.getElementsByAttributeValue("number", "1");
        System.out.println(id);
    }

    @Test
    public void test4() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        //获取id属性值的元素对象
        Element elementById = parse.getElementById("1");
        System.out.println(elementById);
    }

    @Test
    public void test5() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        Elements from = parse.getElementsByTag("from");
        //获取from对象的属性值，属性名不区分大小写
        String id = from.attr("id");
        System.out.println(id);
        //获取文本内容
        String text = from.text();
        //获取HTML标签
        String html = from.html();
        System.out.println(text);
        System.out.println(html);
    }
}
