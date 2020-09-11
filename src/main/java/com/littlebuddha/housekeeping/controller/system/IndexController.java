package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.common.utils.UserUtils;
import com.littlebuddha.housekeeping.entity.system.Menu;
import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ck
 * @date 2020/7/7 16:45
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = {"/index",""})
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();

        //获取当前用户信息
        Operator currentUser = UserUtils.getPrincipal();
        session.setAttribute("currentUser",currentUser);

        //查询当前用户一级菜单列表
        Menu menu = new Menu();
        menu.setOperator(currentUser);
        List<Menu> menuByOperator = menuService.findMenuByOperator(menu);
        return "system/index";
    }
}
