package com.example.dao;

import com.example.pojo.NewsCategory;
import com.example.util.PageQueryUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ming
 * @date: 2021/10/23 17:08
 */
@Repository
public interface NewsCategoryMapper {
    List<NewsCategory> findCategoryList(PageQueryUtil pageQueryUtil);

    int getTotalCategories(PageQueryUtil pageQueryUtil);

    NewsCategory selectByPrimaryKey(Long categoryId);

    NewsCategory selectByCategoryName(String categoryName);

    int deleteByPrimaryKey(Long categoryId);

    int deleteBatch(Long[] categoryIds);

    int insert(NewsCategory newsCategory);

    int insertSelective(NewsCategory newsCategory);

    int updateByPrimaryKeySelective(NewsCategory newsCategory);

    int updateByPrimaryKey(NewsCategory newsCategory);
}
