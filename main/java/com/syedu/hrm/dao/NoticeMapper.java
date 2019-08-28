package com.syedu.hrm.dao;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.Notice;
import com.syedu.hrm.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * NoticeMapper 数据访问类
 * @author zht
 * @email 304804773@qq.com
 * @date 2019-07-29 16:45:51
 * @version 1.0
 */
@Mapper
public interface NoticeMapper extends BaseMapper {


    List<Notice> selectAllNotice();

    void addNotice(Notice notice);

    List<Notice> selectNoticeByTitle(String title);

    void deleteNoticeById(int id);

    Notice selectNoticeById(int id);

    void upDateNotice(Notice notice);
}