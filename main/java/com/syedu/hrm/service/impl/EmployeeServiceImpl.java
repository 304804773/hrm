package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.Employee;
import com.syedu.hrm.bean.EmployeeInfo;
import com.syedu.hrm.dao.EmployeeMapper;
import com.syedu.hrm.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void add(Employee employee) {
        employeeMapper.save(employee);
    }

    @Override
    public List<Employee> find() {
        return employeeMapper.find(null);
    }

    @Override
    public Employee get(int id) {
        return employeeMapper.get(id);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public List<EmployeeInfo> downExcel(HttpServletRequest request, HttpServletResponse response) {
        //先获取需要拿到的数据
        List<EmployeeInfo>employeeInfos=employeeMapper.findAll(null);
        return  employeeInfos;
    }

    @Override
    public List<Employee> getEmployeeByPage(int jobId, String name, String cardId, int sex, String phone, int deptId) {

        Map<String, Object> params = new HashMap<>();
        if (jobId > 0) {
            params.put("jobId", jobId);
        }
        if (StringUtils.isNotEmpty(name)) {
            params.put("name", "%" + name + "%");
        }
        if (StringUtils.isNotEmpty(cardId)) {
            params.put("cardId", "%" + cardId + "%");
        }
        if (sex > 0) {
            params.put("sex", sex);
        }
        if (StringUtils.isNotEmpty(phone)) {
            params.put("phone", phone + "%");
        }
        if (deptId > 0) {
            params.put("deptId", deptId);
        }

        return employeeMapper.findByPage(params);
    }
}
