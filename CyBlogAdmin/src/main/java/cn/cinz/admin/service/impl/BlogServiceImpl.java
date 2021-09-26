package cn.cinz.admin.service.impl;


import cn.cinz.admin.mapper.BlogMapper;
import cn.cinz.admin.model.Blog;
import cn.cinz.admin.model.BlogAdd;
import cn.cinz.admin.model.BlogQuery;
import cn.cinz.admin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (描述功能模块)
 *
 * @Author: zengcheng
 * @Description: (内容作用)
 * @Date: 2021/9/11 22:23
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<BlogAdd> selectBlogList(BlogQuery blogQuery) {

        List<BlogAdd> list = blogMapper.selectBlogList(blogQuery);

        return list;
    }

    @Override
    public Integer countBlog() {
        return blogMapper.countBlog();
    }

    @Override
    public int updateByPrimaryKey(Blog blog) {
        return 0;
    }

    @Override
    public int delete(Blog blog) {
        return 0;
    }

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }
}
