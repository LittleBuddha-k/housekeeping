package com.littlebuddha.housekeeping.entity.system;

import com.littlebuddha.housekeeping.entity.other.DataEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 操作用户实体类
 * @author ck
 * @date 2020/7/7 9:31
 */
public class Operator extends DataEntity<Operator> {
    private String name;//姓名
    private String password;//密码
    private String salt;//盐值
    private String picture;//图片

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;//出生日期

    private String address;//地址
    private String sex;//性别 性别 0-男 1-女
    private Integer age;//年龄
    private Integer isMarry;//婚否 婚否 0-未婚 1-已婚
    private String hobby;//爱好
    private String specialty;//特长
    private String primarySchool;//小学
    private String middleSchool;//中学
    private String highSchool;//高中
    private String university;//大学
    private String otherEducation;//其他学历
    private String skill;//技能
    private Company company;//在职公司
    private String resume;//履历
    private Area area;//所在地区地址
    private String phone;//电话
    private String email;//邮箱

    private Integer usingStatus;//是否启用 0-未启用 1-已启用

    //仅用于查询
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(Integer isMarry) {
        this.isMarry = isMarry;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPrimarySchool() {
        return primarySchool;
    }

    public void setPrimarySchool(String primarySchool) {
        this.primarySchool = primarySchool;
    }

    public String getMiddleSchool() {
        return middleSchool;
    }

    public void setMiddleSchool(String middleSchool) {
        this.middleSchool = middleSchool;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getOtherEducation() {
        return otherEducation;
    }

    public void setOtherEducation(String otherEducation) {
        this.otherEducation = otherEducation;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    public Integer getUsingStatus() {
        return usingStatus;
    }

    public void setUsingStatus(Integer usingStatus) {
        this.usingStatus = usingStatus;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
