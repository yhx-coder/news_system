package com.example.service.impl;

import com.example.dao.NewsCategoryMapper;
import com.example.pojo.NewsCategory;
import com.example.service.CategoryService;
import com.example.util.PageQueryUtil;
import com.example.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ming
 * @date: 2021/10/28 12:33
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private NewsCategoryMapper categoryMapper;

    @Override
    public List<NewsCategory> getAllCategories() {
        return categoryMapper.findCategoryList(null);
    }

    @Override
    public NewsCategory queryById(Long categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public PageResult getCategoryPage(PageQueryUtil pageUtil) {
        List<NewsCategory> categoryList = categoryMapper.findCategoryList(pageUtil);
        int totalCategories = categoryMapper.getTotalCategories(null);

        return new PageResult(pageUtil.getPage(),
                pageUtil.getLimit(),
                totalCategories,
                categoryList);
    }

    @Override
    public Boolean saveCategory(String categoryName) {
        NewsCategory category = categoryMapper.selectByCategoryName(categoryName);
        if (category == null) {
            NewsCategory newsCategory = new NewsCategory();
            newsCategory.setCategoryName(categoryName);
            return categoryMapper.insertSelective(newsCategory) > 0;
        }
        return false;
    }

    @Override
    public Boolean updateCategory(Long categoryId, String categoryName) {
        NewsCategory category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category != null) {
            category.setCategoryName(categoryName);
            return categoryMapper.updateByPrimaryKeySelective(category) > 0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatchByIds(Long[] ids) {
        if (ids.length < 1) {
            return false;
        }
        return categoryMapper.deleteBatch(ids) > 0;
    }

    @Override
    public Boolean deleteById(Long categoryId) {
        return categoryMapper.deleteByPrimaryKey(categoryId) > 0;
    }
}
