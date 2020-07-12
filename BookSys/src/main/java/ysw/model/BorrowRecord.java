package ysw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 21:29
 * @Version
 **/
@Getter
@Setter
@ToString
public class BorrowRecord {
    private Integer id;
    private Integer bookId;
    private Integer studentId;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Book book;
    private Classes classes;
    private Student student;
}
