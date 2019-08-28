package com.syedu.hrm.service;

import com.syedu.hrm.bean.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> find();

    void save(Dept dept);

    void deleteDept(int id);

    Dept get(int id);

    void updateDept(Dept dept);

    String loadJobAjax();

    List<Dept> getDepts();
}
