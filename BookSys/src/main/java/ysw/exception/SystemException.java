package ysw.exception;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 20:20
 * @Version
 **/
public class SystemException extends BaseException{
    public SystemException(String code, String message) {
        super("Sys"+code, "系统异常"+message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("Sys"+code, "系统异常"+message, cause);
    }
}
