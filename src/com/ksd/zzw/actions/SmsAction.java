package com.ksd.zzw.actions;

import com.ksd.zzw.entity.Sms;
import com.ksd.zzw.service.SmsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.sql.Timestamp;

public class SmsAction extends ActionSupport implements ModelDriven<Sms> {

    @Resource(name = "smsService")
    SmsService smsService;

    private String method;
    private Sms sms = new Sms();

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Sms getSms() {
        return sms;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public String dealSms() {
        if ("toadd".equals(method)) {
            return "toadd";
        }
       /* else if ("toedit".equals(method)) {
            sms = smsService.getSms(sms.getId());
            Map map = (Map) ActionContext.getContext().get("request");
            map.put("sms", sms);
            return "toedit";
        }*/
        else if ("delete".equals(method)) {
            smsService.deleteSms(sms);
            return "success";
        } else if ("add".equals(method)) {
            sms.setSendtime(new Timestamp(System.currentTimeMillis()));
            sms.setIsread("0");
            System.out.println(sms.toString());
            smsService.addSms(sms);
            return "success";
        } else if ("modify".equals(method)) {
            sms = smsService.getSms(sms.getId());
            sms.setIsread("1");
            smsService.modifySms(sms);
            return "success";
        } else
            return "error";
    }

    @Override
    public Sms getModel() {
        return this.sms;
    }
}
