package cn.cinz.admin.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客实体类
 *
 * @Author: zengcheng
 * @Description: (内容作用)
 * @Date: 2021/9/11 22:10
 */
public class Blog implements Serializable {

    private static final long serialVersionUID = 6650314398100775661L;

    private String id;//博客id
    private String title;//博客标题

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")//避免从数据库取日期的时候 变成时间戳
    private Date createDate;//博客创建时间

    private String memo;//博客便签
    private String value;//博客内容
    private String status;//博客状态 私有 公用
    private int pageViews;//博客浏览量
    private String uId;//博客作者


    public Blog() {
    }


    public Blog(String id, String title, Date createDate, String memo, String value, String status, String uId) {
        this.id = id;
        this.title = title;
        this.createDate = createDate;
        this.memo = memo;
        this.value = value;
        this.status = status;
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", memo='" + memo + '\'' +
                ", value='" + value + '\'' +
                ", status='" + status + '\'' +
                ", pageViews=" + pageViews +
                ", uId='" + uId + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPageViews() {
        return pageViews;
    }

    public void setPageViews(int pageViews) {
        this.pageViews = pageViews;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
