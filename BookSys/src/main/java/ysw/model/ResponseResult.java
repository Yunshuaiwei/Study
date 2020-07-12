package ysw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 20:46
 * @Version
 **/
@Getter
@Setter
@ToString
public class ResponseResult {
    private boolean success;
    private String code;
    private String message;
    //分页
    private Integer total;
    //业务数据
    private Object data;
    //出现异常时的堆栈信息
    private String stackTrace;

}
