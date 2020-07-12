package ysw.exception;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 20:19
 * @Version
 **/
public class ClientException extends BaseException{
    public ClientException(String code, String message) {
        super("Client："+code, "客户端异常："+message);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("Client："+code, "客户端异常："+message, cause);
    }
}
