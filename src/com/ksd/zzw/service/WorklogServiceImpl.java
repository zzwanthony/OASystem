package com.ksd.zzw.service;

import com.ksd.zzw.dao.IWorklogDAO;
import com.ksd.zzw.entity.Worklog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("worklogService")
public class WorklogServiceImpl implements WorklogService {

    @Resource(name="worklogDao")
    private IWorklogDAO worklogDAO;

    @Override
    public List<Worklog> getWorklogPage(String username,Integer currentPage, Integer pageSize) {
        return worklogDAO.getMeetingPage(username,currentPage,pageSize);
    }

    @Override
    public Integer getAllCount(String username) {
        return worklogDAO.getAllCount(username);
    }

    @Override
    public void modifyWorklog(Worklog worklog) {
        worklogDAO.modifyWorklog(worklog);
    }

    @Override
    public void addWorklog(Worklog worklog) {
        worklogDAO.addWorklog(worklog);
    }

    @Override
    public void deleteWorklog(Worklog worklog) {
        worklogDAO.deleteWorklog(worklog);
    }

    @Override
    public Worklog getWorklog(Integer id) {
        return worklogDAO.getWorklog(id);
    }
}
