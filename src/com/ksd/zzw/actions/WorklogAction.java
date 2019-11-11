package com.ksd.zzw.actions;

import com.ksd.zzw.entity.Worklog;
import com.ksd.zzw.service.WorklogService;
import com.ksd.zzw.util.UtilTime;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Map;

public class WorklogAction extends ActionSupport implements ModelDriven<Worklog> {

    @Resource(name = "worklogService")
    WorklogService worklogService;

    private String method;
    private Worklog worklog = new Worklog();
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

    public Worklog getWorklog() {
        return worklog;
    }

    public void setWorklog(Worklog worklog) {
        this.worklog = worklog;
    }

    public String dealWorklog() {
        if ("toadd".equals(method)) {
            return "toadd";
        } else if ("toedit".equals(method)) {
            worklog = worklogService.getWorklog(worklog.getId());
            Map map = (Map) ActionContext.getContext().get("request");
            map.put("worklog",worklog);
            return "toedit";
        } else if ("delete".equals(method)) {
            worklogService.deleteWorklog(worklog);
            return "success";
        } else if("add".equals(method)){
            worklog.setWorkTime(UtilTime.FormatTime(time2));
            worklog.setLogtime(new Timestamp(System.currentTimeMillis()));
            worklogService.addWorklog(worklog);
            return "success";
        } else if("modify".equals(method)){
            worklog.setWorkTime(UtilTime.FormatTime(time2));
            worklogService.modifyWorklog(worklog);
            return "success";
        } else
            return "error";
    }

    @Override
    public Worklog getModel() {
        return this.worklog;
    }
}
