package com.littlebuddha.housekeeping.common.other;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * UUID自动生成id
 * @author ck
 * @date 2020/7/8 11:11
 */
public class AutoId {
    private static SecureRandom random = new SecureRandom();

    /**
     * uuid自动生成32位
     * @return
     */
    public static String getAutoId(){
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static char[] randomLong() {
        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        boolean[] flag = new boolean[letters.length];//初始化都为false
        char[] results = new char[5];
        for (int i = 0; i < 5; i++) {
            int index = 0;
            do {
                index = (int) (Math.random() * 26);//第一个肯定是不重复的
            } while (flag[index]);
            results[i] = letters[index];
            flag[index] = true;
        }
        return results;
    }

}
