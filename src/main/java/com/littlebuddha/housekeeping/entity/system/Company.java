package com.littlebuddha.housekeeping.entity.system;

import com.littlebuddha.housekeeping.entity.other.DataEntity;

/**
 * 公司实体
 * @author ck
 * @date 2020/7/7 10:18
 */
public class Company extends DataEntity<Company> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
