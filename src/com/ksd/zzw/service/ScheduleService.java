package com.ksd.zzw.service;

import com.ksd.zzw.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getSchedulePage(String username, Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    void modifySchedule(Schedule schedule);

    void addSchedule(Schedule schedule);

    void deleteSchedule(Schedule schedule);

    Schedule getSchedule(Integer id);
}
