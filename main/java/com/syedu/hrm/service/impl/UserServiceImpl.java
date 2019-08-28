package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.User;
import com.syedu.hrm.dao.UserMapper;
import com.syedu.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUser(int id) {
        return userMapper.get(id);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public List<User> find() {
        return userMapper.find(null);
    }

    @Override
    public void checkUser(int id) {
        userMapper.update(id);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return userMapper.updateUser(user);
    }
}
