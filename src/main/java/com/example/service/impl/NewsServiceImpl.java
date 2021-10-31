package com.example.service.impl;

import com.example.dao.NewsMapper;
import com.example.pojo.News;
import com.example.service.NewsService;
import com.example.util.PageQueryUtil;
import com.example.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: ming
 * @date: 2021/10/31 16:35
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public String saveNews(News news) {
        if (newsMapper.insertSelective(news) > 0) {
            return "success";
        } else {
            return "保存失败";
        }
    }

    @Override
    public PageResult getNewsPages(PageQueryUtil pageQueryUtil) {
        int totalNews = newsMapper.getTotalNews(null);
        List<News> newsList = newsMapper.findNewsList(pageQueryUtil);
        return new PageResult(pageQueryUtil.getPage(), pageQueryUtil.getLimit(), totalNews, newsList);
    }

    @Override
    public News queryNewsById(Long newsId) {
        return newsMapper.selectByPrimaryKey(newsId);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return newsMapper.deleteBatch(ids) > 0;
    }

    @Override
    public String updateNews(News news) {
        News newsForUpdate = newsMapper.selectByPrimaryKey(news.getNewsId());
        if (newsForUpdate == null) {
            return "数据不存在";
        }
        news.setNewsCategoryId(news.getNewsCategoryId());
        news.setNewsContent(news.getNewsContent());
        news.setNewsCoverImage(news.getNewsCoverImage());
        news.setNewsStatus(news.getNewsStatus());
        news.setNewsTitle(news.getNewsTitle());
        news.setUpdateTime(new Date());
        if (newsMapper.updateByPrimaryKeySelective(news) > 0) {
            return "success";
        }
        return "修改失败";
    }
}
