package yswblog.exception;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 19:02
 * @Version
 **/
public class ClientException extends BaseException {

    public ClientException(String code, String message) {
        super(code, message, null);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI" + code, "客户端异常" + message, cause);
    }
}
