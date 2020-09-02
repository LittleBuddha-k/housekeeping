package com.littlebuddha.housekeeping.entity.livebroadcast;

import com.littlebuddha.housekeeping.entity.other.DataEntity;

import java.util.Date;

/**
 * 家政员实体类
 * @author ck
 * @date 2020/7/15 15:02
 */
public class Anchor extends DataEntity<Anchor> {

    private String name;
    private Integer age;
    private String sex;
    private Date birthday;

    private LiveBroadCastingRoom liveBroadCastingRoom;//直播间外键
    private Integer viewNow;
    private boolean isAlive;
    private Integer numberOfSubscriptions;

    private String address;
    private String phone;
    private String email;
    private String picture;
    private String company;
    private String skill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public LiveBroadCastingRoom getLiveBroadCastingRoom() {
        return liveBroadCastingRoom;
    }

    public void setLiveBroadCastingRoom(LiveBroadCastingRoom liveBroadCastingRoom) {
        this.liveBroadCastingRoom = liveBroadCastingRoom;
    }

    public Integer getViewNow() {
        return viewNow;
    }

    public void setViewNow(Integer viewNow) {
        this.viewNow = viewNow;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Integer getNumberOfSubscriptions() {
        return numberOfSubscriptions;
    }

    public void setNumberOfSubscriptions(Integer numberOfSubscriptions) {
        this.numberOfSubscriptions = numberOfSubscriptions;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
