package yswblog.exception;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/18 20:19
 * @Version
 **/
public class BusinessException extends BaseException{
    public BusinessException(String code, String message) {
        super(code, message,null);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super("BUS"+code, "业务异常"+message, cause);
    }
}
