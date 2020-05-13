package yswblog.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/13 17:14
 * @Version
 **/
public class JSONUtil {
    private static volatile ObjectMapper MAPPER;

    public static ObjectMapper get() {
        if (MAPPER == null) {//双重校验锁
            synchronized (JSONUtil.class) {
                if (MAPPER == null) {
                    MAPPER = new ObjectMapper();
                }
            }
        }
        return MAPPER;
    }

    /**
     * Java序列化为Json字符串
     *
     * @return Json字符串
     * @Param [o] 对象
     **/
    public static String serialize(Object o) {
        try {
            return get().writeValueAsString(o);
        } catch (JsonProcessingException e) {//将编译时异常转换为运行时，编译时不处理
            throw new RuntimeException("Json序列化失败，对象为" + o);
        }
    }

    /**
     * 将Json字符串反序列化为Java对象
     *
     * @return T 反序列化后的Java对象
     * @Param [Json, clazz] json字符串，java类型
     **/
    public static <T> T deserialize(String Json, Class<T> clazz) {
        try {
            return get().readValue(Json, clazz);
        } catch (IOException e) {

            throw new RuntimeException("反序列化失败，Json字符串为" + Json);
        }
    }

    public static <T> T deserialize(InputStream is, Class<T> clazz) {
        try {
            return get().readValue(is, clazz);
        } catch (IOException e) {

            throw new RuntimeException("反序列化失败");
        }
    }
}
