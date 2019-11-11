package com.ksd.zzw.service;

import com.ksd.zzw.dao.IMeetingDAO;
import com.ksd.zzw.entity.Meeting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {

    @Resource(name = "meetingDao")
    private IMeetingDAO meetingDao;

    @Override
    public List<Meeting> getMeetingPage(String username, Integer currentPage, Integer pageSize) {
        return meetingDao.getMeetingPage(username, currentPage, pageSize);
    }

    @Override
    public Integer getAllCount(String username) {
        return meetingDao.getAllCount(username);
    }

    @Override
    public Meeting getMeeting(Integer id) {
        return meetingDao.getMeeting(id);
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetingDao.deleteMeeting(meeting);
    }

    @Override
    public void addMeeting(Meeting meeting) {
        meetingDao.addMeeting(meeting);
    }

    @Override
    public void modifyMeeting(Meeting meeting) {
        meetingDao.modifyMeeting(meeting);
    }
}
