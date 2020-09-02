package com.littlebuddha.housekeeping.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/save")
    public void save(TestEntity testEntity){
        System.out.println("save 控制器执行");
        testService.save(testEntity);
    }

    @RequestMapping("/edit")
    public String edit(){
        return "other/edit";
    }

    @RequestMapping("/update")
    public String update(){
        return "other/update";
    }
}
