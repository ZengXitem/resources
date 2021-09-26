package cn.cinz.admin.interceptor;

import cn.cinz.admin.common.EUser;
import cn.cinz.admin.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 *
 * @Author: zengcheng
 * @Description: 拦截器：放行请求
 * @Date: 2021/9/9 23:11
 */
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        logger.info("拦截器--->(目前请求路径):"+url);

//        HttpSession session = request.getSession();
//        User loginUser = (User) session.getAttribute("user");
//
//        if (loginUser != null){
//
//            if (loginUser.getAuthority() == EUser.普通用户.getValue()){
//                logger.info(EUser.普通用户.getName());
//            }
//
//            if (loginUser.getAuthority() == EUser.超级管理员.getValue()){
//                logger.info("超级管理员");
//            }
//
//
//            return true;
//        }
//
//
//
//
//
//
//        //未登录用户 返回到登陆界面
//
//        logger.info("请先登陆");
//        request.setAttribute("msg","请先登陆");
//        request.getRequestDispatcher("/login").forward(request,response);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
