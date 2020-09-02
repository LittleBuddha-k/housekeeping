package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.common.result.AjaxResult;
import com.littlebuddha.housekeeping.common.utils.UserUtils;
import com.littlebuddha.housekeeping.entity.system.Menu;
import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.service.system.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ModelAttribute
    public Menu get(@RequestParam(required = false) String id) {
        Menu menu = null;
        if (StringUtils.isNotBlank(id)) {
            menu = menuService.get(id);
        }
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    @RequiresPermissions("systemsettings:menu:list")
    @RequestMapping(value = {"/list", ""})
    public String list(Menu menu, Model model) {
        model.addAttribute("menu", menu);
        return "systemsettings/menuList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public List<Menu> data(Menu menu, Model model) {
        List<Menu> list = menuService.findList(menu);
        return list;
    }

    @RequestMapping("/form/{mode}")
    public String form(@PathVariable(name = "mode") String mode, Menu menu, Model model) {
        model.addAttribute("menu", menu);
        model.addAttribute("mode", mode);
        return "systemsettings/menuForm";
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxResult save(Menu menu) {
        AjaxResult ajaxResult = new AjaxResult();
        menuService.save(menu);
        ajaxResult.setStatus(200);
        ajaxResult.setMessage("操作成功！！！");
        return ajaxResult;
    }

    /**
     * 这只是一个逻辑删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteAll")
    public AjaxResult deleteAll(String ids) {
        AjaxResult ajaxResult = new AjaxResult();
        String idArray[] = ids.split(",");
        for (String id : idArray) {
            menuService.deleteByLogic(menuService.get(id));
        }
        ajaxResult.setStatus(200);
        ajaxResult.setMessage("删除操作用户信息成功");
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/test")
    public List<Menu> findTest(Menu menu){
        Operator currentUser = UserUtils.getPrincipal();
        menu.setOperator(currentUser);
        return menuService.findMenuByOperator(menu);
    }
}