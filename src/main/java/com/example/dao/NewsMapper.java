package com.example.dao;

import com.example.pojo.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: ming
 * @date: 2021/10/23 17:06
 */
@Repository
public interface NewsMapper {
    List<News> findNewsList(Map map);

    int getTotalNews(Map map);

    News selectByPrimaryKey(Long newsId);

    int deleteBatch(Integer[] ids);

    int deleteByPrimaryKey(Long newsId);

    int insert(News news);

    int insertSelective(News news);

    int updateByPrimaryKeySelective(News news);

    int updateByPrimaryKey(News news);
}
