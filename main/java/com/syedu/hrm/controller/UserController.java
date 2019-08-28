package com.syedu.hrm.controller;

import com.syedu.hrm.bean.User;
import com.syedu.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
   //去用户添加页面
    @RequestMapping("/user/toAddUser")
    public String toAddUser(){
        return "/user/addUser";
    }
    //添加用户
    @RequestMapping("/user/addUser")
    public void addUser(User user, HttpServletResponse response) throws Exception{
        userService.save(user);
        response.sendRedirect("/user/userList");
    }
    //去用户查询页面
    @RequestMapping("/user/userList")
    public String userList(Model model){
        List<User> users=userService.find();
        model.addAttribute("users",users);
        return "/user/userList";
    }
    //审批用户
    @RequestMapping("/user/checkUser")
    public void checkUser(String id,HttpServletResponse response)throws  Exception{
        userService.checkUser(Integer.parseInt(id));
        response.sendRedirect("/user/userList");
    }
    //修改用户页面
    @RequestMapping("/user/toUpdateUser")
    public String toUpdateUser(String id,Model model){
        User user=userService.getUser(Integer.parseInt(id));
        model.addAttribute("user",user);
        return "/user/updateUser";
    }
    //删除用户
    @RequestMapping("/user/deleteUser")
    public void deleteUser(String id,HttpServletResponse response)throws  Exception{
        userService.deleteUser(Integer.parseInt(id));
        response.sendRedirect("/user/userList");
    }
    //修改用户
    @RequestMapping("/user/updateUser")
    public String updateUser(User user, HttpServletResponse response, Model model) throws  Exception{
        int r=3;
        r=userService.update(user);
        System.out.println(r);
        System.out.println(user.getPassWord());
        System.out.println(user.getNewPwd());
        if(r==0){
          model.addAttribute("user",user);
            return "/user/updateUserFail";
        }
        response.sendRedirect("/user/userList");
        return null;
    }
    //去输入密码错误页面
    @RequestMapping("/user/toUpdateUserFail")
    public String toUpdateUserFail(Model model,User user){
        model.addAttribute("user",user);
        return "/user/updateUserFail";
    }
}
