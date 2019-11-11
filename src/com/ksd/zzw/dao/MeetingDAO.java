package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Meeting;
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

@Repository("meetingDao")
public class MeetingDAO extends HibernateDaoSupport implements IMeetingDAO {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public List<Meeting> getMeetingPage(String username,Integer currentPage, Integer pageSize) {
        List<Meeting> meetingList = (List) getHibernateTemplate().execute(
                new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        // TODO Auto-generated method stub
                        //使用session对象
                        String hql = "from Meeting";
                        Query query = session.createQuery(hql);
                        int begin = currentPage;
                        query.setFirstResult(begin);
                        query.setMaxResults(pageSize);
                        return query.list();
                    }
                }
        );
        return meetingList;
    }

    @Override
    public Integer getAllCount(String username) {
        String hql = "select count(*) from Meeting";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public Meeting getMeeting(Integer id) {
        return getHibernateTemplate().get(Meeting.class,id);
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        getHibernateTemplate().delete(meeting);
    }

    @Override
    public void addMeeting(Meeting meeting) {
        getHibernateTemplate().save(meeting);
    }

    @Override
    public void modifyMeeting(Meeting meeting) {
        getHibernateTemplate().update(meeting);
    }
}
