package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Schedule;
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

@Repository("scheduleDao")
public class ScheduleDAO extends HibernateDaoSupport implements IScheduleDAO {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public List<Schedule> getSchedulePage(String username,Integer currentPage, Integer pageSize) {
        List<Schedule> ScheduleList = (List) getHibernateTemplate().execute(
                new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        // TODO Auto-generated method stub
                        //使用session对象
                        String hql = "from Schedule where username=:username";
                        Query query = session.createQuery(hql).setString("username",username);
                        int begin = currentPage;
                        query.setFirstResult(begin);
                        query.setMaxResults(pageSize);
                        return query.list();
                    }
                }
        );
        return ScheduleList;
    }

    @Override
    public Integer getAllCount(String username) {
        String hql = "select count(*) from Schedule where username=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,username);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public void modifySchedule(Schedule schedule) {
        getHibernateTemplate().update(schedule);
    }

    @Override
    public void addSchedule(Schedule schedule) {
        getHibernateTemplate().save(schedule);
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        getHibernateTemplate().delete(schedule);
    }

    @Override
    public Schedule getSchedule(Integer id) {
        return getHibernateTemplate().get(Schedule.class,id);
    }
}
