package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Worklog;
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

@Repository("worklogDao")
public class WorklogDAO extends HibernateDaoSupport implements IWorklogDAO {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public List<Worklog> getMeetingPage(String username,Integer currentPage, Integer pageSize) {
        List<Worklog> worklogList = (List) getHibernateTemplate().execute(
                new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        // TODO Auto-generated method stub
                        //使用session对象
                        String hql = "from Worklog where username=:username";
                        Query query = session.createQuery(hql).setString("username",username);
                        int begin = currentPage;
                        query.setFirstResult(begin);
                        query.setMaxResults(pageSize);
                        return query.list();
                    }
                }
        );
        return worklogList;
    }

    @Override
    public Integer getAllCount(String username) {
        String hql = "select count(*) from Worklog where username=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,username);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public Worklog getWorklog(Integer id) {
        return getHibernateTemplate().get(Worklog.class,id);
    }

    @Override
    public void deleteWorklog(Worklog worklog) {
        getHibernateTemplate().delete(worklog);
    }

    @Override
    public void addWorklog(Worklog worklog) {
        getHibernateTemplate().save(worklog);
    }

    @Override
    public void modifyWorklog(Worklog worklog) {
        getHibernateTemplate().update(worklog);
    }
}
