package com.eason.lottert.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ 文件名:   MainFilter
 * @ 创建者:   Eason
 * @ 时间:    2018/9/30 8:32
 * @ 描述:
 */
@WebFilter(urlPatterns = {"/forum/comment", "/forum/add", "/user/person", "/order/*"})
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        Object uid = request.getSession().getAttribute("uid");

        if (uid != null) {
            chain.doFilter(request, response);
        } else {
            System.out.println("doFilter------" + request.getRequestURI());
            response.sendRedirect("/user/login");
        }
    }

    @Override
    public void destroy() {

    }
}
