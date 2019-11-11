package com.ksd.zzw.service;

import com.ksd.zzw.entity.Worklog;

import java.util.List;

public interface WorklogService {
    List<Worklog> getWorklogPage(String username, Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    void modifyWorklog(Worklog worklog);

    void addWorklog(Worklog worklog);

    void deleteWorklog(Worklog worklog);

    Worklog getWorklog(Integer id);
}
