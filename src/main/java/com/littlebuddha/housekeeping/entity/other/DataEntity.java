package com.littlebuddha.housekeeping.entity.other;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.littlebuddha.housekeeping.common.other.AutoId;
import com.littlebuddha.housekeeping.entity.system.Operator;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有实体超类
 * @author ck
 * @date 2020/7/7 9:45
 */
public abstract class DataEntity<E> extends BaseEntity<E> implements Serializable {

    private boolean isNewData = false;//此项数据是否为新数据

    private Operator createBy;
    private Date createDate;
    private Operator updateBy;
    private Date updateDate;

    private Integer isDelete=0;//是否删除 0-未删除 1-已删除,默认未删除

    private String remarks;

    @JsonIgnore
    public boolean getIsNewData() {
        return isNewData || StringUtils.isBlank(getId());
    }

    public void setIsNewData(boolean isNewData) {
        this.isNewData = isNewData;
    }

    public Operator getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Operator createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Operator getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Operator updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 保存数据前的操作，手动调用
     */
    public void preInsert(){
        Subject subject = SecurityUtils.getSubject();
        Operator entity = (Operator)subject.getPrincipal();
        if(!this.isNewData){
            setId(AutoId.getAutoId());
        }
        Date now = new Date();
        this.createBy = entity;
        this.createDate = now;
        this.updateBy = entity;
        this.updateDate = this.createDate;
    }

    /**
     * 更新数据前的操作，手动调用
     */
    public void preUpdate(){
        Subject subject = SecurityUtils.getSubject();
        Operator entity = (Operator)subject.getPrincipal();
        this.updateBy = entity;
        this.updateDate = new Date();
    }
}
