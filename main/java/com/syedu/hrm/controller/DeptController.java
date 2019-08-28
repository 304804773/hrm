package com.syedu.hrm.controller;

import com.syedu.hrm.bean.Dept;
import com.syedu.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;
    //去部门添加页面
    @RequestMapping("/dept/toAddDept")
    public String toAddDept(){
        return "/dept/addDept";
    }
    //部门添加
    @RequestMapping("/dept/addDept")
    public void addDept(Dept dept, HttpServletResponse response)throws  Exception{
        deptService.save(dept);
        response.sendRedirect("/dept/deptList");
    }
    //去部门查询页面
    @RequestMapping("/dept/deptList")
    public String deptList(Model model){
        List<Dept>depts=deptService.find();
        model.addAttribute("depts",depts);
        return "/dept/deptList";
    }
    //删除部门
    @RequestMapping("/dept/deleteDept")
    public void deleteDept(String id,HttpServletResponse response)throws  Exception{
        deptService.deleteDept(Integer.parseInt(id));
        response.sendRedirect("/dept/deptList");
    }
    //去修改部门页面
    @RequestMapping("/dept/toUpdateDept")
    public String toUpdate(String id,Model model){
        Dept dept=deptService.get(Integer.parseInt(id));
        model.addAttribute("dept",dept);
        return "dept/updateDept";
    }
    //修改部门内容
    @RequestMapping("/dept/updateDept")
    public void updateDept(Dept dept,HttpServletResponse response)throws Exception{
        deptService.updateDept(dept);
        response.sendRedirect("/dept/deptList");
    }
    @RequestMapping("/dept/loadDeptAjax")
    @ResponseBody
    public String loadJobAjax(){
        return deptService.loadJobAjax();
    }

}
