package com.syedu.hrm.controller;

import com.syedu.hrm.bean.Job;
import com.syedu.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping("/job/loadJobAjax")
    @ResponseBody
    public String loadJobAjax(){
        return jobService.loadJobAjax();
    }
    //去职位添加页面
    @RequestMapping("/job/toAddJob")
    public String toAddJob(){
        return "/job/addJob";
    }
    //添加职位
    @RequestMapping("/job/addJob")
    public void addJob(Job job, HttpServletResponse response) throws  Exception{
        jobService.save(job);
        response.sendRedirect("/job/jobList");
    }
    //去查询职位页面
    @RequestMapping("/job/jobList")
    public String jobList(Model model){
        List<Job> jobs=jobService.find();
        model.addAttribute("jobs",jobs);
        return "/job/jobList";
    }
    //去更新职位信息页面
    @RequestMapping("/job/toUpdateJob")
    public String toUpdateJob(String id,Model model){
        Job job=jobService.selectJobById(Integer.parseInt(id));
        model.addAttribute("job",job);
        return "/job/updateJob";
    }
    @RequestMapping("/job/updateJob")
    public void updateJob(Job job,HttpServletResponse response)throws  Exception{
        jobService.update(job);
        response.sendRedirect("/job/jobList");
    }
    @RequestMapping("/job/deleteJob")
    public void deleteJob(String id,HttpServletResponse response)throws Exception{
        jobService.deleteJob(Integer.parseInt(id));
        response.sendRedirect("/job/jobList");
    }

}
