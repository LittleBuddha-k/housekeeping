package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Area;
import com.littlebuddha.housekeeping.entity.system.Street;
import com.littlebuddha.housekeeping.service.system.StreetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 区域管理controller类
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/system/street")
public class StreetController {


    @Autowired
    private StreetService streetService;

    @ModelAttribute
    public Street get(@RequestParam(required = false)String id){
        Street street = null;
        if(StringUtils.isNotBlank(id)){
            street = streetService.get(id);
        }else {
            street = new Street();
        }
        return street;
    }

    @RequestMapping(value = {"/list",""})
    public String list(Street street, Model model){
        model.addAttribute("street",street);
        return "system/streetList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Page<Street> data(HttpServletRequest request, HttpServletResponse response, Street street){
        return streetService.findPage(new Page<>(request,response),street);
    }
}
