package com.example.util;

/**
 * @author: ming
 * @date: 2021/10/24 21:38
 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页查询参数
 */
@Getter
@Setter
@ToString
public class PageQueryUtil extends HashMap<String,Object> {
    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer limit;

    public PageQueryUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }

}
