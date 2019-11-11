package com.ksd.zzw.dao;

import com.ksd.zzw.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.List;

@Repository("userDao")
public class UserDAO extends HibernateDaoSupport implements IUserDAO {

    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    public User userLogin(String username, String password) {
        String hql = "FROM User WHERE username = ? AND password = ?";
        //List<User> list = new BaseDao().currentSession().createQuery(hql).setString(0,username).setString(1,password).list();
        @SuppressWarnings("unchecked")
		List<User> list = (List<User>)super.getHibernateTemplate().find(hql,username,password);
        if(list.size()>0)
        	return list.get(0);
        else
        	return null;
    }

	@Override
	public void userRegister(String userName, String userPassword, String email) {
		// TODO Auto-generated method stub
		User user = new User(userName,userPassword,email);
		super.getHibernateTemplate().save(user);
	}

	@Override
	public User userIsExit(String userName) {
		String hql = "FROM User WHERE username = ?";
        //List<User> list = new BaseDao().currentSession().createQuery(hql).setString(0,username).setString(1,password).list();
        @SuppressWarnings("unchecked")
		List<User> list = (List<User>)super.getHibernateTemplate().find(hql,userName);
        if(list.size()>0)
        	return list.get(0);
        else
        	return null;
	}

	@Override
	public void updatePassword(User user) {
		getHibernateTemplate().update(user);
	}
}
