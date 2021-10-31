package com.example.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: ming
 * @date: 2021/10/23 18:06
 */
@Getter
@Setter
@ToString
@Component
public class News {
    /**
     * 新闻主键 ID
     */
    private Long newsId;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻类型
     */
    private Long newsCategoryId;
    /**
     * 新闻封面图
     */
    private String newsCoverImage;

    /**
     * 新闻内容
     */
    private String newsContent;
    /**
     * 发布状态 0-发布 1-草稿
     */
    private Byte newsStatus;
    /**
     * 浏览量
     */
    private Long newsViews;

    /**
     * 是否已删除 0-未删除 1-已删除
     */
    private Byte isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public void setNewsCoverImage(String newsCoverImage) {
        this.newsCoverImage = newsCoverImage == null ? null : newsCoverImage.trim();
    }

}
