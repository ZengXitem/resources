package cn.cinz.admin.mapper;

import cn.cinz.admin.model.User;
import cn.cinz.admin.model.UserQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (描述功能模块)
 *
 * @Author: zengcheng
 * @Description: (内容作用)
 * @Date: 2021/9/6 23:18
 */
@Repository
public interface UserMapper {

    /**
     * 获得用户列表
     * @param userQuery
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

    User insertQQUser(User user);

    User selectUser(User user);

    User selectQQUser(User user);

}
