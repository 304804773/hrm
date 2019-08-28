package com.syedu.hrm.controller;

import com.alibaba.fastjson.JSONObject;
import com.syedu.hrm.bean.User;
import com.syedu.hrm.constat.WebConstant;
import com.syedu.hrm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
   private LoginService loginService;

    @RequestMapping("/tologin")
    public String test() {
        return "login";
    }

    @RequestMapping("/loginAjax")
    @ResponseBody
    public String loginAjax(String userId, String password, String code, HttpServletRequest request) {

        //创建json对象
        JSONObject jsonObject = new JSONObject();

        User user = loginService.findByNameAndPwd(userId, password);

        //把user放入session作用域中
        request.getSession().setAttribute(WebConstant.SESSION_USER, user);

        jsonObject.put("flag", "0");
        jsonObject.put("tip", "登录成功");
        return jsonObject.toString();


    }

    ;
}
