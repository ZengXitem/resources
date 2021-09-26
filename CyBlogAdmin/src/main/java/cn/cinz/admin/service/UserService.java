package cn.cinz.admin.service;


import cn.cinz.admin.model.User;
import cn.cinz.admin.model.UserQuery;

import java.util.List;

/**
 * (描述功能模块)
 *
 * @Author: zengcheng
 * @Description: (内容作用)
 * @Date: 2021/9/6 23:19
 */
public interface UserService {

    /**
     * 获得用户列表
     * @return
     */
    List<User> selectUserList(UserQuery userQuery);

    /**
     * 统计用户数量
     * @return
     */
    Integer countUser();

    /**
     * 注册
     * @param user
     * @return
     */
    User insertUser(User user);

    /**
     * qq注册
     * @param user
     * @return
     */
    User insertQQUser(User user);


}
