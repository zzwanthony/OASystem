package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Notice;
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

@Repository("noticeDao")
public class NoticeDAO extends HibernateDaoSupport implements INoticeDAO {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public List<Notice> getNoticePage(String username,Integer currentPage, Integer pageSize) {
        List<Notice> noticeList = (List) getHibernateTemplate().execute(
                new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        // TODO Auto-generated method stub
                        //使用session对象
                        String hql = "from Notice";
                        Query query = session.createQuery(hql);
                        int begin = currentPage;
                        query.setFirstResult(begin);
                        query.setMaxResults(pageSize);
                        return query.list();
                    }
                }
        );
        return noticeList;
    }

    @Override
    public Integer getAllCount(String username) {
        String hql = "select count(*) from Notice ";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public void modifyNotice(Notice notice) {
        getHibernateTemplate().update(notice);
    }

    @Override
    public void addNotice(Notice notice) {
        getHibernateTemplate().save(notice);
    }

    @Override
    public void deleteNotice(Notice notice) {
        getHibernateTemplate().delete(notice);
    }

    @Override
    public Notice getNotice(Integer id) {
        return getHibernateTemplate().get(Notice.class,id);
    }
}
