package cn.cinz.admin.controller;

import cn.cinz.admin.common.ResultJson;
import cn.cinz.admin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 博客首页
 *
 * @Author: zengcheng
 * @Description: 博客首页 内容处理
 * @Date: 2021/9/9 21:46
 */
@Controller
@CrossOrigin
public class HomeController {


    //请求数据
    @ResponseBody
    @RequestMapping("/user/home/listData")
    public ResultJson listData(HttpSession session){

        User user = (User) session.getAttribute("user");

        if (user == null){
            return ResultJson.error().message("数据获取失败，请联系管理员");
        }else {
            return ResultJson.ok().data(user);
        }
    }

}
