package com.littlebuddha.housekeeping.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ck
 * @date 2020/9/27 15:26
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "system/home";
    }
}
