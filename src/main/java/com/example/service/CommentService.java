package com.example.service;

import com.example.pojo.NewsComment;
import com.example.util.PageQueryUtil;
import com.example.util.PageResult;

/**
 * @author: ming
 * @date: 2021/10/29 12:25
 */
public interface CommentService {
    /**
     * 添加评论
     * @param newsComment
     * @return
     */
    Boolean addComment(NewsComment newsComment);

    /**
     * 评论分页
     * @param pageUtil
     * @return
     */
    PageResult getCommentsPage(PageQueryUtil pageUtil);

    /**
     * 批量审核
     * @param ids
     * @return
     */
    Boolean checkDone(Long[] ids);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Boolean deleteBatch(Long[] ids);
}
