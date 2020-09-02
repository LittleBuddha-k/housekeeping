package com.littlebuddha.housekeeping.common.result;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ck
 * @date 2020/7/10 16:26
 */
public class AjaxResult {

    private Integer status;
    private String message;

    private LinkedHashMap<String, Object> body = new LinkedHashMap<String, Object>();//封装json的map

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LinkedHashMap<String, Object> getBody() {
        return body;
    }

    public void setBody(LinkedHashMap<String, Object> body) {
        this.body = body;
    }
    public void put(String key, Object value){//向json中添加属性，在js中访问，请调用data.map.key
        body.put(key, value);
    }

    public void remove(String key){
        body.remove(key);
    }
}
