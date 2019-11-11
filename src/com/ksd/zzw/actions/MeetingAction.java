package com.ksd.zzw.actions;

import com.ksd.zzw.entity.Meeting;
import com.ksd.zzw.service.MeetingService;
import com.ksd.zzw.util.UtilTime;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.util.Map;

public class MeetingAction extends ActionSupport implements ModelDriven<Meeting> {
    String method;
    Meeting meeting = new Meeting();
    String time2;
    String time3;
    @Resource(name="meetingService")
    MeetingService meetingService;

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public Meeting getModel() {
        return this.meeting;
    }

    public String dealMeeting() throws Exception {
        if ("toadd".equals(method)) {
            return "toadd";
        } else if ("toedit".equals(method)) {
            meeting = meetingService.getMeeting(meeting.getId());
            Map map = (Map) ActionContext.getContext().get("request");
            map.put("meeting",meeting);
            return "toedit";
        } else if ("delete".equals(method)) {
            meetingService.deleteMeeting(meeting);
            return "success";
        } else if("add".equals(method)){
            meeting.setStarttime(UtilTime.FormatTime(time2));
            meeting.setEndtime(UtilTime.FormatTime(time3));
            meetingService.addMeeting(meeting);
            return "success";
        } else if("modify".equals(method)){
            meeting.setStarttime(UtilTime.FormatTime(time2));
            meeting.setEndtime(UtilTime.FormatTime(time3));
            meetingService.modifyMeeting(meeting);
            return "success";
        } else
            return "error";
    }
}
