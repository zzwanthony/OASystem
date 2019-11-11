package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Meeting;

import java.util.List;

public interface IMeetingDAO {

    List<Meeting> getMeetingPage(String username,Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    Meeting getMeeting(Integer id);

    void deleteMeeting(Meeting meeting);

    void addMeeting(Meeting meeting);

    void modifyMeeting(Meeting meeting);
}
