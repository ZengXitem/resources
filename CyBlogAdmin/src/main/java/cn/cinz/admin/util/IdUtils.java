package cn.cinz.admin.util;

import java.util.UUID;

/**
* UUID生成类
* @Author: zengcheng
* @Description: UUID生成
* @Date: 2021/9/20 0:19
*
*/
public class IdUtils {

    /**
     * 生成一个随机id
     * @return
     */
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
