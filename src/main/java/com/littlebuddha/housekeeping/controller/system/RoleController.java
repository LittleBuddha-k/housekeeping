package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.common.result.AjaxResult;
import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Role;
import com.littlebuddha.housekeeping.service.system.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ModelAttribute
    public Role get(@RequestParam(required = false) String id) {
        Role role = null;
        if (StringUtils.isNotBlank(id)) {
            role = roleService.get(id);
        }
        if (role == null) {
            role = new Role();
        }
        return role;
    }

    @RequiresPermissions("system:role:list")
    @RequestMapping(value = {"/list", ""})
    public String list(Role role, Model model) {
        model.addAttribute("role", role);
        return "system/roleList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Page<Role> data(Role role, Model model) {
        Page<Role> rolePage = roleService.findPage(new Page<Role>(), role);
        return rolePage;
    }

    @RequestMapping("/form/{mode}")
    public String form(@PathVariable(name = "mode") String mode, Role role, Model model) {
        model.addAttribute("role", role);
        model.addAttribute("mode", mode);
        return "systemsettings/roleForm";
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxResult save(Role role) {
        AjaxResult ajaxResult = new AjaxResult();
        roleService.save(role);
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
            roleService.deleteByLogic(roleService.get(id));
        }
        ajaxResult.setStatus(200);
        ajaxResult.setMessage("删除操作用户信息成功");
        return ajaxResult;
    }
}
