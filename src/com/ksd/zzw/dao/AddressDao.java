package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Address;
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

@Repository("addressDao")
public class AddressDao extends HibernateDaoSupport implements IAddressDao {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public List<Address> getPageAddress(String username, Integer currentPage, Integer pageSize) {
//        super.getHibernateTemplate().find(hql,currentPage,pageSize);
//        List<Address> stus = (List<Address>)session.createQuery("select stu from Student stu where stu.room.name like :room and sex like :sex")
//                .setParameter("room", "%计算机应用%").setParameter("sex", "%女%").setFirstResult(0).setMaxResults(10)
//                .list();
//        List<Address> list=(List<Address>) this.getHibernateTemplate().execute((HibernateCallback<Address>) new PageHibernateCallback("from Address", new Object[]{}, currentPage, pageSize));
        List<Address> addressList = (List) getHibernateTemplate().execute(
                new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        // TODO Auto-generated method stub
                        //使用session对象
                        String hql = "from Address where username=:username";
                        Query query = session.createQuery(hql).setString("username",username);
                        int begin = currentPage;
                        query.setFirstResult(begin);
                        query.setMaxResults(pageSize);
                        return query.list();
                    }
                }
        );
        return addressList;
    }

    @Override
    public Integer getAllCount(String username) {
        String hql = "select count(*) from Address where username=?";
        List<Long> list = this.getHibernateTemplate().find(hql,username);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public void deleteAddress(Address address) {
        getHibernateTemplate().delete(address);
    }

    @Override
    public Address getAddress(Integer id) {
        return getHibernateTemplate().get(Address.class,id);
    }

    @Override
    public void addAddress(Address address) {
        getHibernateTemplate().save(address);
    }

    @Override
    public void modifyAddress(Address address) {
        getHibernateTemplate().update(address);
    }
}
