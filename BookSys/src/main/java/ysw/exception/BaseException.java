package ysw.exception;


import lombok.Getter;
import lombok.Setter;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 20:13
 * @Version
 **/
@Getter
@Setter
public class BaseException extends RuntimeException{
    protected String code;

    public BaseException(String code,String message) {
        super(message);
        this.code=code;
    }

    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }
}
