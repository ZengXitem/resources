package cn.cinz.admin.model;

/**
 * 博客新增实体类
 *
 * @Author: zengcheng
 * @Description: 博客新增实体类，新增属性放这里
 * @Date: 2021/9/12 14:03
 */
public class BlogAdd extends Blog{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
