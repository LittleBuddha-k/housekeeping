package com.littlebuddha.housekeeping.controller.system;

import com.littlebuddha.housekeeping.entity.system.City;
import com.littlebuddha.housekeeping.service.system.CityService;
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
 * 城市管理controller类
 *
 * @author ck
 * @date 2020/8/12 13:48
 */
@Controller
@RequestMapping("/system/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @ModelAttribute
    public City get(@RequestParam(required = false) String id) {
        City city = null;
        if (StringUtils.isNotBlank(id)) {
            city = cityService.get(id);
        } else {
            city = new City();
        }
        return city;
    }

    @RequestMapping("/list")
    public String list(City city, Model model) {
        model.addAttribute("city", city);
        return "system/cityList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public List<City> data(City city) {
        List<City> cityList = cityService.findList(city);
        return cityList;
    }
}
