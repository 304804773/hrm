package com.syedu.hrm.controller;

import com.syedu.hrm.bean.Dept;
import com.syedu.hrm.bean.Employee;
import com.syedu.hrm.bean.EmployeeInfo;
import com.syedu.hrm.bean.Job;
import com.syedu.hrm.service.DeptService;
import com.syedu.hrm.service.EmployeeService;
import com.syedu.hrm.service.JobService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private JobService jobService;
    @RequestMapping("/emp/toAddEmp")
    //去添加员工页面
    public String toAddEmp(Model model){
        List<Dept>depts=deptService.find();
        model.addAttribute("depts",depts);
        return "/emp/addEmp";
    }
    //添加员工
    @RequestMapping("/employee/addEmp")
    public void addEmp(HttpServletResponse response,Employee employee)throws  Exception{
        employeeService.add(employee);
        response.sendRedirect("/emp/empList");
    }
    //去员工查询页面
    @RequestMapping("/emp/empList")
    public String selectAllEmp(Model model){
        List<Employee> employees=employeeService.find();
        List<Dept>depts=deptService.find();
        List<Job>jobs=jobService.find();
        model.addAttribute("employees",employees);
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        return "/emp/empList";
    }
    //去修改员工页面
    @RequestMapping("/emp/toUpdateEmp")
    public String toUpdateEmp(Model model,String id){
        Employee employee=employeeService.get(Integer.parseInt(id));
        model.addAttribute("emp",employee);
        return "/emp/updateEmp";
    }
    //修改员工
    @RequestMapping("/emp/updateEmp")
    public void updateEmp(Employee employee,HttpServletResponse response)throws  Exception{
        employeeService.update(employee);
        response.sendRedirect("/emp/empList");
    }
    //导出EXCEL文件
    @RequestMapping("/employee/downExcel")
    public void downExcel(HttpServletResponse response, HttpServletRequest request)throws  Exception{
       //导出的文件
       List<EmployeeInfo> employeeInfos= employeeService.downExcel(request,response);
        //定义导出excel的标题
        String[]title={"编号","姓名","性别","手机号码","邮箱","职位","学历","身份证号码","部门","联系地址","日期"};
        String sheetname="员工信息";
        //创建工作表
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建工作表中的工作单
        HSSFSheet sheet=workbook.createSheet(sheetname);
        //创建行
        HSSFRow row=sheet.createRow(0);//标题行
        //创建列
        for(int i=0;i<title.length;i++){
            HSSFCell cell=row.createCell(i);
            //设置cell的值
            cell.setCellValue(title[i]);
        }
        //把需要导出的数据放入excel中
        for(int i=0;i<employeeInfos.size();i++){
            //创建行
            row=sheet.createRow(i+1);

            EmployeeInfo employeeInfo=employeeInfos.get(i);
            Field[]fields =employeeInfo.getClass().getDeclaredFields();
            for (int j=0;j<title.length;j++){
                HSSFCell cell=row.createCell(j);
                Field field=fields[j];
                if (field.isAccessible()){
                    field.setAccessible(true);
                }
                Object o=field.get(employeeInfo);
                cell.setCellValue(o.toString());
            }
        }
        response.setHeader("Content-Disposition", "attachment;filename=员工表.xls");
        workbook.write(response.getOutputStream());
    }
    //查询员工
    @RequestMapping("/employee/selectEmployee")
    public String selectEmployee(Model model,Employee employee){

        /* int jobId,String name,String cardId,int sex,String phone,int deptId,Model model*/
        /*  jobId, name, cardId, sex, phone, deptId*/
        List<Employee> employees = employeeService.getEmployeeByPage(employee.getJob().getId(),employee.getName(),employee.getCardId(),employee.getSex(),employee.getPhone(),employee.getDept().getId());
        List<Dept> depts = deptService.getDepts();
        model.addAttribute("employees",employees);
        model.addAttribute("depts",depts);
        return "emp/empList";

    }
}
