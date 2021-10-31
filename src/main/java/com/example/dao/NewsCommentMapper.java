package com.example.dao;

import com.example.pojo.NewsComment;
import com.example.util.PageQueryUtil;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: ming
 * @date: 2021/10/23 17:07
 */
@Repository
public interface NewsCommentMapper {
    List<NewsComment> findNewsCommentList(Map map);

    int getTotalNewsComments(Map map);

    NewsComment selectByPrimaryKey(Long commentId);

    int checkDone(Long[] commentIds);

    int deleteBatch(Long[] commentIds);

    int insert(NewsComment newsComment);

    int insertSelective(NewsComment newsComment);

    int updateByPrimaryKeySelective(NewsComment newsComment);

    int updateByPrimaryKey(NewsComment newsComment);

}
