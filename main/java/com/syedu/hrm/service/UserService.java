package com.syedu.hrm.service;

import com.syedu.hrm.bean.User;

import java.util.List;

public interface UserService {
    public User getUser(int id);

    void save(User user);

    List<User> find();

    void checkUser(int id);

    void deleteUser(int id);

    int update(User user);
}
