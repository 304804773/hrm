package com.syedu.hrm.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syedu.hrm.bean.Job;
import com.syedu.hrm.dao.JobMapper;
import com.syedu.hrm.service.JobService;
import org.apache.jasper.tagplugins.jstl.core.ForEach;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    @Override
    public String loadJobAjax() {
        List<Job>jobs=jobMapper.find(null);
        JSONArray array=new JSONArray();
        for(Job job:jobs){
            JSONObject json=new JSONObject();
            json.put("id",job.getId());
            json.put("name",job.getName());
            array.add(json);

        }
        return array.toString();
    }

    @Override
    public void save(Job job) {
        jobMapper.save(job);
    }

    @Override
    public List<Job> find() {
        return jobMapper.find(null);
    }

    @Override
    public Job selectJobById(int id) {
        return jobMapper.get(id);
    }

    @Override
    public void update(Job job) {
        jobMapper.update(job);
    }

    @Override
    public void deleteJob(int id) {
        jobMapper.delete(id);
    }
}
