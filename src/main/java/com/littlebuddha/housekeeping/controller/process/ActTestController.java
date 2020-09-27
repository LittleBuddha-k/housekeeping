package com.littlebuddha.housekeeping.controller.process;

import com.littlebuddha.housekeeping.common.result.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ck
 * @date 2020/9/27 16:15
 */
@Controller
@RequestMapping("/system/act")
public class ActTestController {

    @GetMapping("/actTestForm")
    public String actTestForm(){

        return "process/actForm";
    }

    @PostMapping("/actTestAdd")
    public AjaxResult actTestAdd(){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setStatus(200);
        ajaxResult.setMessage("流程发起成功");
        return ajaxResult;
    }
}
