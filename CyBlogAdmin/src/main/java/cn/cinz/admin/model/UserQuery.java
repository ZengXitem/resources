package cn.cinz.admin.model;

/**
 * (描述功能模块)
 *
 * @Author: zengcheng
 * @Description: (内容作用)
 * @Date: 2021/9/25 18:33
 */
public class UserQuery extends User{

    private Integer limit;
    private Integer page;
    private Integer count;


    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
