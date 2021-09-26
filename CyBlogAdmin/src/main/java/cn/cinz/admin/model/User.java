package cn.cinz.admin.model;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
* 用户实体类
* @Author: zengcheng
* @Description: 用户实体类
* @Date: 2021/9/20 0:18
*
*/
public class User implements Serializable {

    private static final long serialVersionUID = 6650314398100775661L;

    private String id;//用户id
    private String name;//用户昵称
    private String phone;//用户手机
    private String img;//用户头像
    private String sex;//用户性别
    private int experience;//用户经验值

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;//用户注册时间

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;//每一次的登录时间 更新

    private int logoutStatus;//用户注销状态
    private int authority;//权限

    public User() {
    }

    /**
     * 手机号注册使用
     * @param id UUID
     * @param phone 手机号
     * @param authority 权限
     */
    public User(String id, String phone, Date registerDate, int authority) {
        this.id = id;
        this.phone = phone;
        this.registerDate = registerDate;
        this.authority = authority;
    }

    /**
     * QQ登陆注册
     * @param id QID
     * @param name QNAME
     * @param img QIMG
     * @param sex SEX
     * @param authority 权限
     */
    public User(String id, String name, String img, String sex, Date registerDate, int authority) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.sex = sex;
        this.registerDate = registerDate;
        this.authority = authority;
    }

    public User(String id, String name, String phone, String img, String sex, int experience, Date registerDate, Date endTime, int logoutStatus, int authority) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.img = img;
        this.sex = sex;
        this.experience = experience;
        this.registerDate = registerDate;
        this.endTime = endTime;
        this.logoutStatus = logoutStatus;
        this.authority = authority;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", img='" + img + '\'' +
                ", sex='" + sex + '\'' +
                ", experience=" + experience +
                ", registerDate=" + registerDate +
                ", endTime=" + endTime +
                ", logoutStatus=" + logoutStatus +
                ", authority=" + authority +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getLogoutStatus() {
        return logoutStatus;
    }

    public void setLogoutStatus(int logoutStatus) {
        this.logoutStatus = logoutStatus;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
