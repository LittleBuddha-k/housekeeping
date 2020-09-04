package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Area;
import com.littlebuddha.housekeeping.service.system.AreaService;
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
@RequestMapping("/system/area")
public class AreaController {

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
        return "system/areaList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Page<Area> data(HttpServletRequest request, HttpServletResponse response, Area area){
        return areaService.findPage(new Page<>(request,response),area);
    }
}
