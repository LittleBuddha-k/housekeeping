package com.littlebuddha.housekeeping.controller.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Street;
import com.littlebuddha.housekeeping.service.systemsettings.StreetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 区域管理controller类
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/systemsettings/streetManager")
public class StreetManagerController {


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
        return "systemsettings/streetList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public List<Street> data(Street street){
        List<Street> streetList = streetService.findList(street);
        return streetList;
    }
}
