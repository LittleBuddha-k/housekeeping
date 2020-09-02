package com.littlebuddha.housekeeping.security;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * shiro的AUTHC属性为FormAuthenticationFilter表单验证
 *自定义FormAuthenticationFilter，设置验证码在认证之前校验
 * @author ck
 * @date 2020/7/22 10:14
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //在这里进行验证码校验
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        //如果验证码校验失败，将失败信息，通过shiroLoginFailure设置到request中
        String validateCode = (String) session.getAttribute("validateCode");

        //取出页面的验证码,输入的和shirosession的验证码进行对比
        String randomCode = httpServletRequest.getParameter("randomCode");
        if(randomCode !=null && validateCode != null && !randomCode.equals(validateCode)){
            httpServletRequest.setAttribute("shiroLoginFailure","randomCodeError");
            //拒绝访问,不在校验账户和密码
            return true;
        }
        return super.onAccessDenied(request, response);
    }
}
