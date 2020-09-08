package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.common.result.AjaxResult;
import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.service.system.OperatorService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Controller
@RequestMapping("/system/operator")
public class OperatorController {

    HiddenHttpMethodFilter hiddenHttpMethodFilter;

    @Autowired
    private OperatorService operatorService;

    @ModelAttribute
    public Operator get(@RequestParam(required = false)String id){
        Operator operator = null;
        if (StringUtils.isNotBlank(id)){
            operator = operatorService.get(id);
        }
        if (operator == null){
            operator = new Operator();
        }
        return operator;
    }

    @RequiresPermissions("system:operator:list")
    @RequestMapping("/list")
    public String list(Operator operator, Model model){
        model.addAttribute("operator",operator);
        return "system/operatorList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Page<Operator> data(Operator operator, Model model){
        Page<Operator> operatorPage = operatorService.findPage(new Page<Operator>(), operator);
        return operatorPage;
    }

    /**
     * 是为增、删、改、查做的form表单
     * @param mode
     * @param operator
     * @param model
     * @return
     */
    @RequestMapping("/form/{mode}")
    public String form(@PathVariable(name = "mode")String mode, Operator operator, Model model){
        model.addAttribute("operator",operator);
        model.addAttribute("mode",mode);
        return "system/operatorForm";
    }

    /**
     * 是为点击个人信息时所展示的当前登录用户的form表单
     * @param operator
     * @param model
     * @return
     */
    @RequestMapping("/form/info")
    public String form(Operator operator, Model model){
        Subject subject = SecurityUtils.getSubject();
        operator = (Operator) subject.getPrincipal();
        model.addAttribute("operator",operator);
        return "system/operatorForm";
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxResult save(Operator operator){
        AjaxResult ajaxResult = new AjaxResult();
        int row = operatorService.save(operator);
        if(row == 1) {
            ajaxResult.setStatus(200);
            ajaxResult.setMessage("操作成功！！！");
        }else {
            ajaxResult.setStatus(500);
            ajaxResult.setMessage("操作失败！！！");
        }
        return ajaxResult;
    }

    /**
     * 这只是一个逻辑删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteAll")
    public AjaxResult deleteAll(String ids) {
        AjaxResult ajaxResult = new AjaxResult();
        String idArray[] =ids.split(",");
        for(String id : idArray){
            operatorService.deleteByLogic(id);
        }
        ajaxResult.setStatus(200);
        ajaxResult.setMessage("删除操作用户信息成功");
        return ajaxResult;
    }

    public AjaxResult dataExport(Operator operator){

        return null;
    }
}
