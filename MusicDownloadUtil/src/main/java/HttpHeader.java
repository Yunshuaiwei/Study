import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

/**
 * @author yunshuaiwei
 * @className HttpHeader
 * @description: TODO
 * @date 2021/10/24 14:39
 */
public class HttpHeader {
    @Value("http.cookie")
    private static String cookie;

    /**
     * @author yunshuaiwei
     * @description 请求头
     * @date 16:03 2021/10/24
     * @Param []
     * @Return org.springframework.http.HttpHeaders
     */
    public static HttpHeaders getHttpHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("cookie",cookie);
        headers.add("accept","*/*");
        headers.add("accept-language","zh-CN,zh;q=0.9");
        headers.add("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36");

        return headers;
    }
}
