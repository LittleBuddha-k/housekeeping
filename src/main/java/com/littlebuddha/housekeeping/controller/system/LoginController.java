package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.common.utils.MD5Encryption;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author ck
 * @date 2020/7/16 10:54
 */
@Controller
public class LoginController {

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "system/login";
    }

    /**
     * 此方法不处理登陆成功，使用shiro认证成功后会自动跳转到上一个请求路径
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam(name = "username", required = true) String username,
                        @RequestParam(name = "password", required = true) String password,
                        HttpServletRequest request) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            currentUser.login(usernamePasswordToken);
        }
        //如果登陆失败，从request、中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String shiroLoginFailure = (String) request.getAttribute("shiroLoginFailure");

        if (shiroLoginFailure != null) {
            if (UnknownAccountException.class.getName().equals(shiroLoginFailure)) {

                //最终会抛给异常处理器
                throw new RuntimeException("未知账户不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)) {
                throw new RuntimeException("用户名/密码错误");
            } else {
                throw new RuntimeException();//生成最终异常未知
            }
        }
        //该方法不处理登陆成功(认证成功),shiro认证成功后会自动跳转到上一个路径
        //登录失败过后还是返回到登陆页面
        return "system/login";
    }

    @RequestMapping("/logOut")
    public String logOut(Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("message","退出成功");
        return "sys/login";
    }
}
