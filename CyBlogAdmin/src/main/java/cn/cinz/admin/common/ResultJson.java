package cn.cinz.admin.common;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共JSON格式类
 *
 * @Author: zengcheng
 * @Description: 返回公共JSON信息
 * @Date: 2021/9/4 15:23
 */
public class ResultJson {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "范围 (例如1-10条数据)")
    private Integer limit;

    @ApiModelProperty(value = "页码")
    private Integer page;

    @ApiModelProperty(value = "数据总条数")
    private Integer count;

    @ApiModelProperty(value = "返回数据")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")//避免从数据库取日期的时候 变成时间戳
    private Map<String, Object> data = new HashMap<String, Object>();

    private ResultJson() {
    }

    public static ResultJson ok() {
        ResultJson r = new ResultJson();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static ResultJson error() {
        ResultJson r = new ResultJson();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public ResultJson success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResultJson message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultJson code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultJson limit(Integer limit) {
        this.setLimit(limit);
        return this;
    }

    public ResultJson page(Integer page) {
        this.setPage(page);
        return this;
    }

    public ResultJson count(Integer count) {
        this.setCount(count);
        return this;
    }

    public ResultJson data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    public ResultJson data(Object value) {
        this.data.put("items", value);
        return this;
    }



    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

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
