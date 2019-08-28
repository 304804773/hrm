package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.Notice;
import com.syedu.hrm.bean.User;
import com.syedu.hrm.dao.NoticeMapper;
import com.syedu.hrm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectAllNotice() {
        return noticeMapper.selectAllNotice();
    }

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }

    @Override
    public List<Notice> selectNoticeByTitle(String title) {
        return noticeMapper.selectNoticeByTitle(title);
    }

    @Override
    public void deleteNoticeById(int id) {
        noticeMapper.deleteNoticeById(id);
    }

    @Override
    public Notice selectNoticeById(int id) {
        return noticeMapper.selectNoticeById(id);
    }

    @Override
    public void upDateNotice(Notice notice) {
        noticeMapper.upDateNotice(notice);
    }
}
