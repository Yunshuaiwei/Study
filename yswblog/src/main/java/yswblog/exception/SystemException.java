package yswblog.exception;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/16 21:49
 * @Version
 **/
public class SystemException extends BaseException{

    public SystemException(String code, String message) {
        super(code, message,null);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("SYS"+code, "系统异常："+message, cause);
    }
}
