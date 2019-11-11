package com.ksd.zzw.service;

import com.ksd.zzw.entity.Sms;

import java.util.List;

public interface SmsService {

    List<Sms> getSmsPage(String username, Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    Sms getSms(Integer id);

    void deleteSms(Sms sms);

    void addSms(Sms sms);

    void modifySms(Sms sms);
}
