package yswblog.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import yswblog.model.Article;

import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 16:57
 * @Version
 **/
public class JSONUtilTest {

    @Test
    public void test1(){
        ObjectMapper mapper = new ObjectMapper();
        Article article = new Article();
        article.setId(1);
        article.setTitle("Java编程思想");
        article.setContent("面向对象！");
        article.setUserId(1);
        article.setCreateTime(new Date());

        try {
            //将字符串序列化json
            String s = mapper.writeValueAsString(article);
            System.out.println(s);
            //将json反序列化为Java对象
            Article art = mapper.readValue(s, Article.class);
            System.out.println(art.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
