package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: ming
 * @date: 2021/10/23 17:53
 */

@Getter
@Setter
@ToString
@Component
public class NewsComment {
    /**
     * 评论主键 id
     */
    private Long commentId;
    /**
     * 评论新闻的主键 id
     */
    private Long newsId;
    /**
     * 评论人
     */
    private String commentator;
    /**
     * 评论内容
     */
    private String commentBody;
    /**
     * 评论状态 0-未审核 1-审核通过
     */
    private Byte commentStatus;
    /**
     * 是否已删除 0-未删除 1-已删除
     */
    private Byte isDeleted;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public void setCommentator(String commentator) {
        this.commentator = commentator == null ? null : commentator.trim();
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody == null ? null : commentBody.trim();
    }
}
