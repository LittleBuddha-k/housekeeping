package com.littlebuddha.housekeeping.entity.other;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.littlebuddha.housekeeping.common.utils.UserUtils;
import com.littlebuddha.housekeeping.entity.system.Operator;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * @author ck
 * @date 2020/8/17 14:36
 */
public class BaseEntity<E> implements Serializable {

    private String id;//实体类的唯一标识

    /**
     * 当前用户
     */
    protected Operator currentUser;

    /**
     * 当前实体分页对象
     * @return
     */
    private Page<E> page;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public Operator getCurrentUser() {
        if(currentUser == null){
            currentUser = UserUtils.getPrincipal();
        }
        return currentUser;
    }

    public void setCurrentUser(Operator currentUser) {
        this.currentUser = currentUser;
    }

    @JsonIgnore
    @XmlTransient
    public Page<E> getPage() {
        if (page == null){
            page = new Page<E>();
        }
        return page;
    }

    public Page<E> setPage(Page<E> page) {
        this.page = page;
        return page;
    }

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";
}
