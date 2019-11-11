package com.ksd.zzw.service;

import com.ksd.zzw.dao.ISmsDAO;
import com.ksd.zzw.entity.Sms;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("smsService")
public class SmsServiceImpl implements SmsService {

    @Resource(name = "smsDao")
    private ISmsDAO smsDAO;

    @Override
    public List<Sms> getSmsPage(String username, Integer currentPage, Integer pageSize) {
        return smsDAO.getSmsPage(username, currentPage, pageSize);
    }

    @Override
    public Integer getAllCount(String username) {
        return smsDAO.getAllCount(username);
    }

    @Override
    public Sms getSms(Integer id) {
        return smsDAO.getSms(id);
    }

    @Override
    public void deleteSms(Sms sms) {
        smsDAO.deleteSms(sms);
    }

    @Override
    public void addSms(Sms sms) {
        smsDAO.addSms(sms);
    }

    @Override
    public void modifySms(Sms sms) {
        smsDAO.modifySms(sms);
    }
}
