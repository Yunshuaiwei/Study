package yswblog.exception;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 18:54
 * @Version
 **/
public class BaseException extends RuntimeException{

    protected String code;

    protected String message;

    public BaseException(String code) {
        this(code,null);
    }

    public BaseException(String code,String message) {
        this(code, message, null);
    }

    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
