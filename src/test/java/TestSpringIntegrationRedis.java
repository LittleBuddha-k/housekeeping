import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ck
 * @date 2020/8/21 11:20
 */
@ContextConfiguration("classpath:spring/spring-redis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringIntegrationRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testIntegrationRedis(){
        redisTemplate.opsForValue().set("key123","value123");
    }
}
