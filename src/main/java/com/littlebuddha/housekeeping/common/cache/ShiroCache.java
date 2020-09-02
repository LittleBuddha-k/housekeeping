package com.littlebuddha.housekeeping.common.cache;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 与shiro相关的缓存
 * @author ck
 * @date 2020/7/21 17:22
 */
public class ShiroCache {

    public void clearCached(){
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
    }
}
