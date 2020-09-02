import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author ck
 * @date 2020/8/21 10:28
 */
public class TestRedis {

    @Test
    public void TestRedisConnection(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("key02","value01");
    }
}
