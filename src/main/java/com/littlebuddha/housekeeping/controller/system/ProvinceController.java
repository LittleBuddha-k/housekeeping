package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Province;
import com.littlebuddha.housekeeping.service.system.ProvinceService;
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

/**
 * 区域管理controller类
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/system/province")
public class ProvinceController {


    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute
    public Province get(@RequestParam(required = false)String id){
        Province province = null;
        if(StringUtils.isNotBlank(id)){
            province = provinceService.get(id);
        }else {
            province = new Province();
        }
        return province;
    }

    @RequestMapping("/list")
    public String list(Province province, Model model){
        model.addAttribute("province",province);
        return "system/provinceList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Page<Province> data(HttpServletRequest request, HttpServletResponse response, Province province){
        Page<Province> provincePage = provinceService.findPage(new Page<Province>(request,response),province);
        return provincePage;
    }
}
