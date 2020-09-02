package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.common.utils.UserUtils;
import com.littlebuddha.housekeeping.entity.livebroadcast.Anchor;
import com.littlebuddha.housekeeping.entity.livebroadcast.LiveBroadCastingRoom;
import com.littlebuddha.housekeeping.entity.systemsettings.Menu;
import com.littlebuddha.housekeeping.entity.systemsettings.Operator;
import com.littlebuddha.housekeeping.service.livebroadcast.AnchorService;
import com.littlebuddha.housekeeping.service.livebroadcast.LiveBroadCastingRoomService;
import com.littlebuddha.housekeeping.service.systemsettings.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private LiveBroadCastingRoomService liveBroadCastingRoomService;

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
        List<Menu> menus = menuService.findMenuByOperator(menu);
        session.setAttribute("menus",menus);
        return "system/index";
    }
}
