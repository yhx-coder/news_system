package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author: ming
 * @date: 2021/10/23 17:36
 */

@Getter
@Setter
@ToString
@Component
public class NewsCategory {
    /**
     * 类别主键 id
     */
    private Long categoryId;
    /**
     * 类别名称
     */
    private String categoryName;
    /**
     * 是否已删除 0-未删除 1-已删除
     */
    private Byte isDeleted;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
}
