import com.littlebuddha.housekeeping.mapper.test.TestMapper;
import com.littlebuddha.housekeeping.service.system.OperatorService;
import com.littlebuddha.housekeeping.test.TestEntity;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class TestSpring {

    @Test
    public void TestDataBase(){
        AbstractApplicationContext ac
                = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        TestMapper testMapper  = ac.getBean("testMapper", TestMapper.class);
        TestEntity testEntity = new TestEntity();
        testEntity.setName("测试五");
        testEntity.setAddress("平顶山山洞");
        int save = testMapper.save(testEntity);
        if(save == 1){
            System.out.println("保存成功");
        }
    }

    @Test
    public void testSpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        OperatorService operatorService = (OperatorService) applicationContext.getBean("usersService");
        operatorService.toString();
    }

    @Test
    public void getConnection() throws SQLException {
        AbstractApplicationContext ac
                = new ClassPathXmlApplicationContext("spring/spring-context.xml");

        BasicDataSource basicDataSource  = ac.getBean("dataSource", BasicDataSource .class);

        Connection conn = basicDataSource.getConnection();
        System.out.println(conn);

        ac.close();
    }

}
