package com.syedu.hrm.base;

import com.syedu.hrm.bean.User;
import com.syedu.hrm.constat.WebConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录，如果登录跳转到main

        //用户登录成功后会把信息存入到session中，然后在session中取出信息，如果为空则是该用户没有登录
        User user = (User) request.getSession().getAttribute(WebConstant.SESSION_USER);
        if (user != null) {
            return true;
        }
        //如果没有登录跳转到login

        response.sendRedirect("tologin");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
