package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Worklog;

import java.util.List;

public interface IWorklogDAO {

    List<Worklog> getMeetingPage(String username,Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    Worklog getWorklog(Integer id);

    void deleteWorklog(Worklog worklog);

    void addWorklog(Worklog worklog);

    void modifyWorklog(Worklog worklog);
}
