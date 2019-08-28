package com.syedu.hrm.service;

import com.syedu.hrm.bean.Employee;
import com.syedu.hrm.bean.EmployeeInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EmployeeService {
    void add(Employee employee);

    List<Employee> find();

    Employee get(int id);

    void update(Employee employee);

    List<EmployeeInfo> downExcel(HttpServletRequest request, HttpServletResponse response);


    List<Employee> getEmployeeByPage(int jobId, String name, String cardId, int sex, String phone, int deptId);
}
