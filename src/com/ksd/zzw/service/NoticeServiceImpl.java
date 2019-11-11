package com.ksd.zzw.service;

import com.ksd.zzw.dao.INoticeDAO;
import com.ksd.zzw.entity.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

    @Resource(name="noticeDao")
    private INoticeDAO noticeDAO;
    @Override
    public List<Notice> getNoticePage(String username,Integer currentPage, Integer pageSize) {
        return noticeDAO.getNoticePage(username, currentPage,pageSize);
    }

    @Override
    public Integer getAllCount(String username) {
        return noticeDAO.getAllCount(username);
    }

    @Override
    public void modifyNotice(Notice notice) {
        noticeDAO.modifyNotice(notice);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeDAO.addNotice(notice);
    }

    @Override
    public void deleteNotice(Notice notice) {
        noticeDAO.deleteNotice(notice);
    }

    @Override
    public Notice getNotice(Integer id) {
        return noticeDAO.getNotice(id);
    }
}
