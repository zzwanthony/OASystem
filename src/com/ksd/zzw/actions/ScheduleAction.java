package com.ksd.zzw.actions;

import com.ksd.zzw.entity.Schedule;
import com.ksd.zzw.service.ScheduleService;
import com.ksd.zzw.util.UtilTime;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.util.Map;

public class ScheduleAction  extends ActionSupport implements ModelDriven<Schedule> {

    @Resource(name = "scheduleService")
    ScheduleService scheduleService;

    private String method;
    private Schedule schedule = new Schedule();
    private String time2;

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String dealSchedule() {
        if ("toadd".equals(method)) {
            return "toadd";
        } else if ("toedit".equals(method)) {
            schedule = scheduleService.getSchedule(schedule.getId());
            Map map = (Map) ActionContext.getContext().get("request");
            map.put("schedule",schedule);
            return "toedit";
        } else if ("delete".equals(method)) {
            scheduleService.deleteSchedule(schedule);
            return "success";
        } else if("add".equals(method)){
            schedule.setScheduleTime(UtilTime.FormatTime(time2));
            scheduleService.addSchedule(schedule);
            return "success";
        } else if("modify".equals(method)){
            schedule.setScheduleTime(UtilTime.FormatTime(time2));
            scheduleService.modifySchedule(schedule);
            return "success";
        } else
            return "error";
    }

    @Override
    public Schedule getModel() {
        return this.schedule;
    }
}
