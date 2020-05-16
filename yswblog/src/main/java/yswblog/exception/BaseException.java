package yswblog.exception;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 18:54
 * @Version
 **/
public class BaseException extends RuntimeException{

    protected String code;


    public BaseException(String code,String message) {
        this(code, message, null);
    }

    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
