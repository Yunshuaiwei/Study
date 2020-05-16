package yswblog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 16:45
 * @Version
 **/

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
