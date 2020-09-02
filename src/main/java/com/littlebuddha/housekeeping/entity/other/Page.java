package com.littlebuddha.housekeeping.entity.other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 分页实体类
 * @author ck
 * @date 2020/8/14 10:38
 */
public class Page<E> {

    private Integer draw=1;//页数
    private Integer recordsTotal;//总条数
    private Integer recordsFiltered;//总条数      recordsTotal和recordsFiltered必须都是总条数，不然分页只能是一页
    private List<E> data;//数据

    private Integer start=0;
    private Integer length=10;
    private String orderBy = ""; // 标准查询有效， 实例： updatedate desc, name asc

    public Page() {
    }

    public Page(HttpServletRequest request, HttpServletResponse response) {
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
