package com.eason.lottert.filter;

import com.eason.lottert.bean.User;
import com.eason.lottert.service.Impl.UserServiceImpl;
import com.eason.lottert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ 文件名:   AutoLoginFilter
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 20:06
 * @ 描述:
 */
@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        String uid = (String) session.getAttribute("uid");

        if (uid != null) {
            chain.doFilter(request, response);
            return;
        }

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("autologin")) {
                String value = cookie.getValue();
                String[] split = value.split("#");
                String mobile = split[0];
                String password = split[1];

                User user = userService.login(mobile, password);

                session.setAttribute("uid", user.getUid());
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
