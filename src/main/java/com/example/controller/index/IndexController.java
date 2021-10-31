package com.example.controller.index;

import com.example.pojo.News;
import com.example.pojo.NewsComment;
import com.example.service.CommentService;
import com.example.service.NewsService;
import com.example.util.AntiXssUtils;
import com.example.util.Result;
import com.example.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ming
 * @date: 2021/10/31 18:05
 */
@Controller
public class IndexController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/news/{newsId}")
    public String detail(HttpServletRequest request, @PathVariable("newsId") Long newsId) {
        News news = newsService.queryNewsById(newsId);
        if (news != null) {
            request.setAttribute("newsDetail", news);
        }
        request.setAttribute("pageName", "详情");
        return "index/detail";
    }

    @PostMapping(value = "/news/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request,
                          @RequestParam Long newsId,
                          @RequestParam String commentator,
                          @RequestParam String commentBody) {
        String ref = request.getHeader("Referer");
        if (StringUtils.isEmpty(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == newsId || newsId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (StringUtils.isEmpty(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (StringUtils.isEmpty(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }
        NewsComment comment = new NewsComment();
        comment.setNewsId(newsId);
        comment.setCommentator(AntiXssUtils.cleanString(commentator));
        comment.setCommentBody(AntiXssUtils.cleanString(commentBody));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }
}
