package yswblog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 16:46
 * @Version
 **/

@Getter
@Setter
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Date createTime;
    private String userAccout;

}
