package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Notice;

import java.util.List;

public interface INoticeDAO {

	List<Notice> getNoticePage(String username,Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    void modifyNotice(Notice notice);

    void addNotice(Notice notice);

    void deleteNotice(Notice notice);

    Notice getNotice(Integer id);
}
