package ysw.exception;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 20:22
 * @Version
 **/
public class BusinessException extends BaseException{

    public BusinessException(String code, String message) {
        super("BUS"+code, "业务异常："+message);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super("BUS"+code, "业务异常："+message, cause);
    }
}
