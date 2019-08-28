package com.syedu.hrm.service;

import com.syedu.hrm.bean.Job;

import java.util.List;

public interface JobService {
    String loadJobAjax();

    void save(Job job);

    List<Job> find();

    Job selectJobById(int id);

    void update(Job job);

    void deleteJob(int id);
}
