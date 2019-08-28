package com.syedu.hrm.controller;

import com.syedu.hrm.bean.Notice;
import com.syedu.hrm.bean.User;
import com.syedu.hrm.constat.WebConstant;
import com.syedu.hrm.service.NoticeService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    //去添加公告页面
    @RequestMapping("/notice/toAddNotice")
    public String toaddNotice(){
        return "/notice/addNotice";
    }
    //添加公告
    @RequestMapping("/notice/addNotice")
    public void addNotice(Notice notice, HttpServletResponse response, HttpServletRequest request)throws  Exception{
        noticeService.addNotice(notice);
        response.sendRedirect("/notice/noticeList");
    }
    //显示所有公告
    @RequestMapping("/notice/noticeList")
    public String toNoticeList(Model model){
        List<Notice> notices =noticeService.selectAllNotice();
        model.addAttribute("notices",notices);
        return "/notice/noticeList";
    }
    //根据标题查找公告
    @RequestMapping("/notice/selectNotice")
    public String selectNoticeByTitle(String title,Model model){
         List<Notice> notices =noticeService.selectNoticeByTitle(title);
         model.addAttribute("notices",notices);
        return "/notice/noticeList";
    }
    //根据id来删除公告
    @RequestMapping("/notice/deleteNotice")
    public void deleteNoticeById(String id,HttpServletResponse response) throws  Exception{
        noticeService.deleteNoticeById(Integer.parseInt(id));
        response.sendRedirect("/notice/noticeList");
    }
    //进入修改公告页面
    @RequestMapping("/notice/toUpdateNotice")
    public String toUpdateNotice(String id,Model model){
        Notice notice=noticeService.selectNoticeById(Integer.parseInt(id));

        return "/notice/updateNotice";
    }

    //根据id来修改公告
    @RequestMapping("/notice/updateNotice")
    public void upDateNotice(Notice notice,HttpServletResponse response)throws Exception{
        noticeService.upDateNotice(notice);
        response.sendRedirect("/notice/noticeList");
    }
    //预览公告
    @RequestMapping("/notice/prevNotice")
    public String toPrevNotice(String id,Model model){
        Notice notice=noticeService.selectNoticeById(Integer.parseInt(id));
        model.addAttribute("notice",notice);
        return "/notice/prevNotice";
    }
}
