package com.syedu.hrm.dao;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper 数据访问类
 * @author zht
 * @email 304804773@qq.com
 * @date 2019-07-29 16:45:51
 * @version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper {

    User findByNameAndPwd(String name, String password);

   int  updateUser(User user);
}