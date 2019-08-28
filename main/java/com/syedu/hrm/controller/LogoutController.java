package com.syedu.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public void logOut(HttpServletRequest request, HttpServletResponse response)throws Exception{

        //清空Session中的内容
        request.getSession().invalidate();
        //重定向转发
        response.sendRedirect("/tologin");
    }
}
