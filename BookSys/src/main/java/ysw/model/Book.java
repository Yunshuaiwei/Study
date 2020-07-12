package ysw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 21:26
 * @Version
 **/
@Getter
@Setter
@ToString
public class Book extends DictionaryTag{
    private Integer id;
    private String bookName;
    private String author;
    private BigDecimal price;
    private Date createTime;

}
