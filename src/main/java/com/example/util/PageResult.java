package com.example.util;

/**
 * @author: ming
 * @date: 2021/10/24 21:24
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 分页的结果
 */
@Getter
@Setter
@ToString
public class PageResult implements Serializable {
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页数
     */
    private Integer currPage;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 页面数据
     */
    private List<?> list;

    public PageResult(Integer currPage, Integer pageSize, Integer totalCount, List<?> data) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = data;
        this.totalPage = (int)Math.ceil((double) totalCount/pageSize);
    }
}
