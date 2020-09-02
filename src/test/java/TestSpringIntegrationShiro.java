import com.littlebuddha.housekeeping.entity.systemsettings.Operator;
import com.littlebuddha.housekeeping.mapper.systemsettings.MenuMapper;
import com.littlebuddha.housekeeping.mapper.systemsettings.RoleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author ck
 * @date 2020/8/21 11:20
 */
@ContextConfiguration("classpath:spring/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringIntegrationShiro {

    @Autowired
    private SecurityManager securityManager;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void TestLogin(){
        UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        System.out.println("是否具有admin角色"+subject.hasRole("超级管理员"));
        System.out.println("是否具有一级管理员角色"+subject.hasRole("一级管理员"));
        System.out.println("是否具有二级管理员角色"+subject.hasRole("二级管理员"));


        System.out.println("是否具有administor权限"+subject.isPermitted("administor"));
    }

    @Test
    public void TestGetRoles(){
        Operator operator = new Operator();
        operator.setId("1");
        Set<String> roles = roleMapper.findRolesByOperator(operator);
        System.out.println(roles);
    }
}
