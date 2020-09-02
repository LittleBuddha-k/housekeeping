package com.littlebuddha.housekeeping.common.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ck
 * @date 2020/7/28 10:42
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/unAuthorized")
    public String unAuthorizedError(){
        return "error/unAuthorized";
    }

    @RequestMapping("/serviceError")
    public String serviceError(){
        return "error/500";
    }

    @RequestMapping("/routeError")
    public String routeError(){
        return "error/404";
    }
}
