package cn.cinz.admin.service;

import cn.cinz.admin.model.Blog;
import cn.cinz.admin.model.BlogAdd;
import cn.cinz.admin.model.BlogQuery;

import java.util.List;

/**
 * (描述功能模块)
 *
 * @Author: zengcheng
 * @Description: (内容作用)
 * @Date: 2021/9/11 22:23
 */
public interface BlogService{

    /**
     * 查找所有公开博客
     * @param blogQuery
     * @return
     */
    List<BlogAdd> selectBlogList(BlogQuery blogQuery);

    /**
     * 统计博客条数 用于分页
     * @return
     */
    Integer countBlog();

    /**
     * 通过博客id修改博客内容
     * @param blog
     * @return
     */
    int updateByPrimaryKey(Blog blog);

    /**
     * 删除一篇博客
     * @param blog
     * @return
     */
    int delete(Blog blog);

    /**
     * 插入博客
     * @param blog
     * @return
     */
    int insertBlog(Blog blog);

}
