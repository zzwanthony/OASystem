package com.ksd.zzw.actions;

import com.ksd.zzw.entity.Notice;
import com.ksd.zzw.service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Map;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice> {

    private String method;
    Notice notice = new Notice();

    @Resource(name="noticeService")
    NoticeService noticeService;
    @Override
    public Notice getModel() {
        return this.notice;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String dealNotice() throws Exception {
        if ("toadd".equals(method)) {
            return "toadd";
        } else if ("toedit".equals(method)) {
            notice = noticeService.getNotice(notice.getId());
            Map map = (Map) ActionContext.getContext().get("request");
            map.put("notice",notice);
            return "toedit";
        } else if ("delete".equals(method)) {
            noticeService.deleteNotice(notice);
            return "success";
        } else if("add".equals(method)){
            notice.setSendtime(new Timestamp(System.currentTimeMillis()));
            noticeService.addNotice(notice);
            return "success";
        } else if("modify".equals(method)){
            noticeService.modifyNotice(notice);
            return "success";
        } else
            return "error";
    }
}
