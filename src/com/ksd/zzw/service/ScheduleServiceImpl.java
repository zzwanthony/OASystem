package com.ksd.zzw.service;

import com.ksd.zzw.dao.IScheduleDAO;
import com.ksd.zzw.entity.Schedule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Resource(name = "scheduleDao")
    private IScheduleDAO scheduleDAO;

    @Override
    public List<Schedule> getSchedulePage(String username, Integer currentPage, Integer pageSize) {
        return scheduleDAO.getSchedulePage(username, currentPage, pageSize);
    }

    @Override
    public Integer getAllCount(String username) {
        return scheduleDAO.getAllCount(username);
    }

    @Override
    public void modifySchedule(Schedule schedule) {
        scheduleDAO.modifySchedule(schedule);
    }

    @Override
    public void addSchedule(Schedule schedule) {
        scheduleDAO.addSchedule(schedule);
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        scheduleDAO.deleteSchedule(schedule);
    }

    @Override
    public Schedule getSchedule(Integer id) {
        return scheduleDAO.getSchedule(id);
    }
}
