package cn.cinz.admin.controller;

import cn.cinz.admin.common.ResultJson;
import cn.cinz.admin.model.User;
import cn.cinz.admin.model.UserQuery;
import cn.cinz.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器
 *
 * @Author: zengcheng
 * @Description: 用户信息处理
 * @Date: 2021/9/6 22:54
 */
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/user/listData")
    public ResultJson selectUserList(UserQuery userQuery){

        try {
            List<User> userList = userService.selectUserList(userQuery);
            return ResultJson.ok().data(userList).count(userService.countUser());
        }catch (Exception e){
            return ResultJson.error().message(e.getMessage());
        }


    }

    /**
     * Session回收 并重定向到登陆页
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/removeSession", method = RequestMethod.GET)
    public String removeSession(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
