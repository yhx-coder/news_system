package com.example.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: ming
 * @date: 2021/10/25 16:43
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("loginUser") == null) {
            request.getSession().setAttribute("errorMsg", "请重新登录");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }
        request.getSession().removeAttribute("errorMsg");
        return true;
    }
}
