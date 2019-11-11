package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Sms;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository("smsDao")
public class SmsDAO extends HibernateDaoSupport implements ISmsDAO {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public List<Sms> getSmsPage(String username,Integer currentPage, Integer pageSize) {
        List<Sms> SmsList = (List) getHibernateTemplate().execute(
                new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        // TODO Auto-generated method stub
                        //使用session对象
                        String hql = "from Sms where username=:username or sender=:sender";
                        Query query = session.createQuery(hql).setString("username",username).setString("sender",username);
                        int begin = currentPage;
                        query.setFirstResult(begin);
                        query.setMaxResults(pageSize);
                        return query.list();
                    }
                }
        );
        return SmsList;
    }

    @Override
    public Integer getAllCount(String username) {
        String hql = "select count(*) from Sms where username=? or sender=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,username,username);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public Sms getSms(Integer id) {
        return getHibernateTemplate().get(Sms.class,id);
    }

    @Override
    public void deleteSms(Sms sms) {
        getHibernateTemplate().delete(sms);
    }

    @Override
    public void addSms(Sms sms) {
        getHibernateTemplate().save(sms);
    }

    @Override
    public void modifySms(Sms sms) {
        getHibernateTemplate().update(sms);
    }
}
