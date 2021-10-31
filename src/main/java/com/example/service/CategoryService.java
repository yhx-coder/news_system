package com.example.service;

import com.example.pojo.NewsCategory;
import com.example.util.PageQueryUtil;
import com.example.util.PageResult;

import java.util.List;

/**
 * @author: ming
 * @date: 2021/10/28 12:27
 */
public interface CategoryService {

    /**
     * 获取所有类别
     * @return
     */
    List<NewsCategory> getAllCategories();

    /**
     * 根据 id 查询类别信息
     * @param categoryId
     * @return
     */
    NewsCategory queryById(Long categoryId);

    /**
     * 类别数据的分页查询
     * @param pageUtil
     * @return
     */
    PageResult getCategoryPage(PageQueryUtil pageUtil);

    /**
     * 添加类别信息
     * @param categoryName
     * @return
     */
    Boolean saveCategory(String categoryName);

    /**
     * 更新类别
     * @param categoryId
     * @param categoryName
     * @return
     */
    Boolean updateCategory(Long categoryId, String categoryName);

    /**
     * 删除类别 批处理
     * @param ids
     * @return
     */
    Boolean deleteBatchByIds(Long[] ids);

    /**
     * 单个删除
     * @param categoryId
     * @return
     */
    Boolean deleteById(Long categoryId);

}
