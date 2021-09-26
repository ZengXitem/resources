package cn.cinz.admin.controller;

import cn.cinz.admin.common.ResultJson;
import cn.cinz.admin.model.User;
import cn.cinz.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 全局视图控制类
 *
 * @Author: zengcheng
 * @Description: 控制视图跳转
 * @Date: 2021/9/6 22:54
 */
@Controller
@CrossOrigin
public class LoginController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test(){

        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/qq",method = RequestMethod.GET)
    public String qq(){

        return "qq";
    }

//    //登陆验证
//    @RequestMapping(value = "/loginVerification",method = RequestMethod.POST)
//    public String loginVerification( User user, Model model, HttpSession session){
//
//        User userInfo = loginService.insertUser(user);
//
//        if (userInfo.getAuthority() == EUser.普通用户.getValue()){
//            session.setAttribute("user",userInfo);
//            logger.info("=======普通用户访问=======");
//            return "redirect:user/home";
//        }else if (userInfo.getAuthority() == EUser.管理员.getValue()){
//            session.setAttribute("user",userInfo);
//            logger.info("======+=管理员访问=+======");
//            return "admin/index";
//        }else {
//            session.setAttribute("user",userInfo);
//            return "admin/index";
//        }
//
//
//    }


    /**
     * 登陆验证
     * @param user
     * @param model
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginVerification",method = RequestMethod.POST)
    public ResultJson loginVerification(User user, Model model, HttpSession session){
        User userInfo = userService.insertUser(user);
        if (userInfo != null){
            session.setAttribute("user",userInfo);
            return ResultJson.ok().data(userInfo.getAuthority());
        }else {
            return ResultJson.error().message("用户名或密码错误");
        }
    }

    //重定向到首页
    @RequestMapping(value = "/user/home",method = RequestMethod.GET)
    public String home( User user){

        if (user == null){
            return "login";
        }

        return "user/home";
    }

    @RequestMapping(value = "/admin/index",method = RequestMethod.GET)
    public String adminHome(){


        return "admin/index";
    }

            //重定向到首页博客列表
            @RequestMapping(value = "/user/homeBlogList",method = RequestMethod.GET)
            public String homeBlogList(){
                return "user/homeBlogList";
            }

            //重定向到首页博客列表  搜索标题
            @RequestMapping(value = "/user/homeTitleList",method = RequestMethod.GET)
            public String homeTitleList(){
                return "user/homeTitleList";
            }

            //重定向到首页博客显示
            @RequestMapping(value = "/user/homeBlog/{id}",method = RequestMethod.GET)
            public String homeBlog(@PathVariable("id") String id, Model model){

                model.addAttribute("id",id);

                return "user/homeBlog";
            }


    //重定向到打卡
    @RequestMapping(value = "/user/clock_in",method = RequestMethod.GET)
    public String clockIn(){
        return "user/clock_in";
    }

    //重定向到博客
    @RequestMapping(value = "/user/blog",method = RequestMethod.GET)
    public String blog(){
        return "user/blog";
    }

    //重定向到商城
    @RequestMapping(value = "/user/shop",method = RequestMethod.GET)
    public String shop(){
        return "user/shop";
    }

    //重定向到测试域
    @RequestMapping(value = "/user/testDomain",method = RequestMethod.GET)
    public String testDomain(){
        return "user/testDomain";
    }

    //重定向到测试域 demo
    @RequestMapping(value = "/testDomain/MapDemo",method = RequestMethod.GET)
    public String testDomainDemo(){
        return "testDomain/MapDemo";
    }

    //重定向到等级体系
    @RequestMapping(value = "/user/grade_system",method = RequestMethod.GET)
    public String gradeSystem(){
        return "user/grade_system";
    }

    //重定向到个人中心
    @RequestMapping(value = "/user/myzoe",method = RequestMethod.GET)
    public String myzoe(){
        return "user/myzoe";
    }

    @RequestMapping(value = "/user/index",method = RequestMethod.GET)
    public String pay(){
        return "user/index";
    }

    @RequestMapping(value = "/home/console",method = RequestMethod.GET)
    public String console(){
        return "admin/home/console";
    }

}
