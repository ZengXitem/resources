package cn.cinz.admin.model;

/**
* 验证码实体类
* @Author: zengcheng
* @Description: 验证码实体类 重写toString
* @Date: 2021/9/20 0:18
*
*/
public class Code {

    private String code;

    public Code(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return
                "{\"code\"" + ":" + '\"' +
                        "" + code + '\"' +
                        '}';
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
