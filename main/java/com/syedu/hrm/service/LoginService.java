package com.syedu.hrm.service;

import com.syedu.hrm.bean.User;
import org.springframework.stereotype.Service;


public interface LoginService {

    User findByNameAndPwd(String userId, String password);
}
