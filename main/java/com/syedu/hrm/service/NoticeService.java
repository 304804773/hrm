package com.syedu.hrm.service;

import com.syedu.hrm.bean.Notice;
import com.syedu.hrm.bean.User;

import java.util.List;

public interface NoticeService {
    List<Notice> selectAllNotice();

    void addNotice(Notice notice);

    List<Notice> selectNoticeByTitle(String title);

    void deleteNoticeById(int id);

    Notice selectNoticeById(int id);

    void upDateNotice(Notice notice);
}
