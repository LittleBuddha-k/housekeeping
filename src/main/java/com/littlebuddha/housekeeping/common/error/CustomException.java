package com.littlebuddha.housekeeping.common.error;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ck
 * @date 2020/7/28 14:58
 */
public class CustomException implements HandlerExceptionResolver {
    private static final Logger logger = (Logger) LogManager.getLogger(CustomException.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        logger.error("服务器出错",e);
        return null;
    }
}
