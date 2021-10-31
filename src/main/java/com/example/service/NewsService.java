package com.example.service;

import com.example.pojo.News;
import com.example.util.PageQueryUtil;
import com.example.util.PageResult;

/**
 * @author: ming
 * @date: 2021/10/31 16:29
 */
public interface NewsService {
    String saveNews(News news);

    PageResult getNewsPages(PageQueryUtil pageQueryUtil);

    News queryNewsById(Long newsId);

    Boolean deleteBatch(Integer[] ids);

    String updateNews(News news);
}
