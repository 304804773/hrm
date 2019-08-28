package com.syedu.hrm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syedu.hrm.bean.Dept;
import com.syedu.hrm.bean.Job;
import com.syedu.hrm.dao.DeptMapper;
import com.syedu.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> find() {
        return deptMapper.find(null);
    }

    @Override
    public void save(Dept dept) {
        deptMapper.save(dept);
    }

    @Override
    public void deleteDept(int id) {
        deptMapper.delete(id);
    }

    @Override
    public Dept get(int id) {
        return deptMapper.get(id);
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.update(dept);
    }

    @Override
    public String loadJobAjax() {
        List<Dept> depts = deptMapper.find(null);
        JSONArray array = new JSONArray();
        for (Dept dept : depts) {
            JSONObject json = new JSONObject();
            json.put("id", dept.getId());
            json.put("name", dept.getName());
            array.add(json);
        }
        return array.toString();
    }

    @Override
    public List<Dept> getDepts() {
        return deptMapper.find(null);
    }
}
