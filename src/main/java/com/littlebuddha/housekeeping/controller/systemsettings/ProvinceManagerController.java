package com.littlebuddha.housekeeping.controller.systemsettings;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.systemsettings.Province;
import com.littlebuddha.housekeeping.service.systemsettings.ProvinceService;
import com.sun.deploy.net.HttpResponse;
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
@RequestMapping("/systemsettings/provinceManager")
public class ProvinceManagerController {


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
        return "systemsettings/provinceList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Page<Province> data(HttpServletRequest request, HttpServletResponse response, Province province){
        Page<Province> provincePage = provinceService.findPage(new Page<Province>(request,response),province);
        return provincePage;
    }
}
