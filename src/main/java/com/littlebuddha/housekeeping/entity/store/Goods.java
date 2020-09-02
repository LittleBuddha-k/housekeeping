package com.littlebuddha.housekeeping.entity.store;

import com.littlebuddha.housekeeping.entity.other.DataEntity;

import java.util.Date;

/**
 * 商品实体类
 * @author ck
 * @date 2020/7/24 14:05
 */
public class Goods extends DataEntity<Goods> {

    private String name;//产品名
    private String introduction;//产品介绍
    private String picture;//产品图片
    private String price;//产品价格
    private String colour;//产品颜色
    private String specifications;//规格
    private String discount;//产品打折
    private String stockCount;//产品库存数
    private Supplier supplier;//产品供货商
    private Date productDate;//生产日期
    private String qualityAssuranceTime;//品保时长

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStockCount() {
        return stockCount;
    }

    public void setStockCount(String stockCount) {
        this.stockCount = stockCount;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public String getQualityAssuranceTime() {
        return qualityAssuranceTime;
    }

    public void setQualityAssuranceTime(String qualityAssuranceTime) {
        this.qualityAssuranceTime = qualityAssuranceTime;
    }
}
