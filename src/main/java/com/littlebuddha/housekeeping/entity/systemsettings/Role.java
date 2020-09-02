package com.littlebuddha.housekeeping.entity.systemsettings;

import com.littlebuddha.housekeeping.entity.other.DataEntity;

import java.util.List;

/**
 * 角色实体类
 * @author ck
 * @date 2020/7/22 9:37
 */
public class Role extends DataEntity<Role> {

    private String name;
    private Integer dataType;
    private Integer status;

    private List<Menu> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
