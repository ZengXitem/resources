package cn.cinz.admin.controller;

import cn.cinz.admin.common.EBlog;
import cn.cinz.admin.common.ResultJson;
import cn.cinz.admin.model.Blog;
import cn.cinz.admin.model.BlogAdd;
import cn.cinz.admin.model.BlogQuery;
import cn.cinz.admin.model.User;
import cn.cinz.admin.service.BlogService;
import cn.cinz.admin.util.IdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 博客控制器
 *
 * @Author: zengcheng
 * @Description: 博客的所有处理
 * @Date: 2021/9/11 22:50
 */
@Controller
@CrossOrigin
public class BlogController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;

    @ResponseBody
    @RequestMapping(value = "/blog/listData",method = RequestMethod.GET)
    public ResultJson selectBlogList(BlogQuery blogQuery){

        blogQuery.setPage((blogQuery.getPage() * blogQuery.getLimit()) - blogQuery.getLimit());
        blogQuery.setLimit(blogQuery.getLimit());

        List<BlogAdd> list = blogService.selectBlogList(blogQuery);

        if (list != null && list.size() > 0){
            Integer count = blogService.countBlog();
            return ResultJson.ok().data(list).count(count);
        }else {
            return ResultJson.error().message("未找到");
        }
    }



    @ResponseBody
    @RequestMapping(value = "/blog/listData/{id}",method = RequestMethod.POST)
    public ResultJson selectBlogId(@PathVariable("id") String id){

        BlogQuery blog = new BlogQuery();

        blog.setId(id);
        blog.setStatus(EBlog.公开.getValue());
        List<BlogAdd> list = blogService.selectBlogList(blog);

        return ResultJson.ok().data(list);
    }




    @ResponseBody
    @RequestMapping(value = "/blog/insertBlog", method = RequestMethod.POST)
    public ResultJson insertBlog(Blog blog, HttpSession session){

        if (blog.getValue() == null || blog.getValue() == ""){
            return ResultJson.error().message("请填写博客内容");
        }


        User userInfo = (User) session.getAttribute("user");
        blog.setId(IdUtils.getId());
        blog.setCreateDate(new Date());
        blog.setuId(userInfo.getId());
        logger.info(String.valueOf(blog));
        try {
            blogService.insertBlog(blog);
        } catch (Exception e) {
            return ResultJson.error().message(e.getMessage());
        }

        return ResultJson.ok();
    }



}
