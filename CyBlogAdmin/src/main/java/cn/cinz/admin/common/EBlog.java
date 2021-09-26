package cn.cinz.admin.common;

/**
 * 博客枚举类
 *
 * @Author: zengcheng
 * @Description: 描述博客
 * @Date: 2021/9/11 22:40
 */
public enum  EBlog {

    /**
     * 修饰状态
     */
    公开("true","公开"),
    私密("false","私密"),

    ;



    private String value;
    private String name;

    EBlog(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
