package com.littlebuddha.housekeeping.common.utils;

import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * MD5加密
 * @author ck
 * @date 2020/7/17 10:29
 */
public class MD5Encryption {

    public static String getEncryptionPassword(String password,String salt){
        // 拼接原密码与盐值
        String str = salt + password;
        // 循环加密5次
        for (int i = 0; i < 5; i++) {
            str = DigestUtils.md5DigestAsHex(
                    str.getBytes()).toUpperCase();
        }
        return str;
    }
}
