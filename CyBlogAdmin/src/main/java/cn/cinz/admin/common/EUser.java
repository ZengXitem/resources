package cn.cinz.admin.common;

/**
 * 用户枚举类
 *
 * @Author: zengcheng
 * @Description: (用户枚举类) 作用：描述用户
 * @Date: 2021/9/8 22:05
 */
public enum  EUser {

//   修饰注销状态
    注销成功(1,"注销成功"),
    正常(0,"正常"),
//   修饰权限 
    普通用户(10000,"普通用户"),
    管理员(11000,"管理员"),
    超级管理员(11100,"超级管理员"),
    ;



    private Integer value;
    private String name;

    EUser(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
