package com.littlebuddha.housekeeping.controller.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Area;
import com.littlebuddha.housekeeping.service.systemsettings.AreaService;
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
@RequestMapping("/systemsettings/areaManager")
public class AreaManagerController {

    @Autowired
    private AreaService areaService;

    @ModelAttribute
    public Area get(@RequestParam(required = false)String id){
        Area area = null;
        if(StringUtils.isNotBlank(id)){
            area = areaService.get(id);
        }else {
            area = new Area();
        }
        return area;
    }

    @RequestMapping("/list")
    public String list(Area area, Model model){
        model.addAttribute("area",area);
        return "systemsettings/areaList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public List<Area> data(Area area){
        List<Area> areaList = areaService.findList(area);
        return areaList;
    }
}
