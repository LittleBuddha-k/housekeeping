package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.common.result.AjaxResult;
import com.littlebuddha.housekeeping.common.utils.TreeDataUtil;
import com.littlebuddha.housekeeping.common.utils.UserUtils;
import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Menu;
import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.service.system.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @RequiresPermissions("system:menu:list")
    @RequestMapping(value = {"/list", ""})
    public String list(HttpServletRequest request, HttpServletResponse response,Menu menu, Model model) {
        List<Menu> afterSort = new ArrayList<>();//排序后的list
        List<Menu> allList = menuService.findAllList(menu);
        Menu theBiggestMenu = menuService.findTheBiggestMenu(menu);
        List<Menu> sortList = TreeDataUtil.sortList(allList, afterSort, theBiggestMenu.getId());//排序
        List<Menu> afterSetChildrenList = TreeDataUtil.setChildrenList(sortList);//为有子节点的menu设置childrenList
        //List<Menu> list = menuService.findList(menu);
        model.addAttribute("list", afterSetChildrenList);
        model.addAttribute("menu", menu);
        return "system/menuList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Page<Menu> data(HttpServletRequest request, HttpServletResponse response,Menu menu, Model model) {
        List<Menu> afterSort = new ArrayList<>();//排序后的list
        Page<Menu> menuPage = menuService.findPage(new Page<>(request, response), menu);
        Menu theBiggestMenu = menuService.findTheBiggestMenu(menu);
        List<Menu> sortList = TreeDataUtil.sortList(menuPage.getData(), afterSort, theBiggestMenu.getId());//排序
        List<Menu> afterSetChildrenList = TreeDataUtil.setChildrenList(sortList);//为有子节点的menu设置childrenList
        menuPage.setData(afterSetChildrenList);
        return menuPage;
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
        return menuService.findList(menu);
    }
}
