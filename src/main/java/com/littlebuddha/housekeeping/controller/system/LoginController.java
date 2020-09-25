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
                        HttpServletRequest request,
                        Model model) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(usernamePasswordToken);
            return "redirect:/index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("message", "账户错误");
            return "redirect:/loginPage";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("message", "密码错误");
            return "redirect:/loginPage";
        }
    }

    @RequestMapping("/logOut")
    public String logOut(Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("message","退出成功");
        return "sys/login";
    }
}
