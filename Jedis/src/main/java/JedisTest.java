import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/1 18:06
 * @Version
 **/
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("114.55.31.160", 6379);
        System.out.println(jedis.ping());
        Transaction multi = jedis.multi();
        
        jedis.close();
    }
}
