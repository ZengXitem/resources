package cn.cinz.admin.service.impl;

import cn.cinz.admin.common.EUser;
import cn.cinz.admin.mapper.UserMapper;
import cn.cinz.admin.model.User;
import cn.cinz.admin.model.UserQuery;
import cn.cinz.admin.service.UserService;
import cn.cinz.admin.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 登陆验证 注册用户
 *
 * @Author: zengcheng
 * @Description: 登陆验证 注册用户
 * @Date: 2021/9/6 23:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList(UserQuery userQuery) {

        userQuery.setPage(userQuery.getPage()*userQuery.getLimit()-userQuery.getLimit());
        userQuery.setLimit(userQuery.getLimit());

        return userMapper.selectUserList(userQuery);
    }

    @Override
    public Integer countUser() {
        return userMapper.countUser();
    }

    /**
     * 手机号用户
     * 验证是否注册  未注册则直接注册，已注册则登陆
     */
    @Override
    public User insertUser(User user) {
        User userS = userMapper.selectUser(user);

        if (userS != null){
            return userS;
        }else {
            user.setId(IdUtils.getId());
            user.setRegisterDate(new Date());
            user.setAuthority(EUser.普通用户.getValue());
            userMapper.insertUser(user);
            return userS;
        }
    }


    /**
     * QQ用户
     * 验证是否注册  未注册则直接注册，已注册则登陆
     */
    @Override
    public User insertQQUser(User user) {
        User userS = userMapper.selectQQUser(user);

        if (userS != null){
            return userS;
        }else {
            user.setId(user.getId());
            user.setSex(user.getSex());
            user.setRegisterDate(new Date());
            user.setAuthority(EUser.普通用户.getValue());
            user.setImg(user.getImg());
            userMapper.insertQQUser(user);
            return userS;
        }
    }
}
