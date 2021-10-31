package com.example.service.impl;

import com.example.dao.NewsCommentMapper;
import com.example.pojo.NewsComment;
import com.example.service.CommentService;
import com.example.util.PageQueryUtil;
import com.example.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ming
 * @date: 2021/10/29 12:42
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private NewsCommentMapper commentMapper;

    @Override
    public Boolean addComment(NewsComment newsComment) {
        return commentMapper.insertSelective(newsComment) > 0;
    }

    @Override
    public PageResult getCommentsPage(PageQueryUtil pageUtil) {
        int totalNewsComments = commentMapper.getTotalNewsComments(null);
        List<NewsComment> newsCommentList = commentMapper.findNewsCommentList(pageUtil);
        return new PageResult(pageUtil.getPage(),
                pageUtil.getLimit(),
                totalNewsComments,
                newsCommentList);
    }

    @Override
    public Boolean checkDone(Long[] ids) {
        return commentMapper.checkDone(ids) > 0;
    }

    @Override
    public Boolean deleteBatch(Long[] ids) {
        return commentMapper.deleteBatch(ids) > 0;
    }
}
