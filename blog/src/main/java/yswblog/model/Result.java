package yswblog.model;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 17:52
 * @Version
 **/
public class Result {
    private boolean success;

    private String message;

    private String stackTrace;

    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
