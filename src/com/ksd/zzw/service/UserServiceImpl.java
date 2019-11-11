package com.ksd.zzw.service;

import com.ksd.zzw.dao.IUserDAO;
import com.ksd.zzw.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name="userDao")
    private IUserDAO userDao;

    public User userLogin(String username, String password) {
        return userDao.userLogin(username,password);
    }

	@Override
	public void userRegister(String userName, String userPassword, String email) {
		userDao.userRegister(userName,userPassword,email);
		
	}

	@Override
	public User userIsExit(String userName) {
		// TODO Auto-generated method stub
		return userDao.userIsExit(userName);
	}

	@Override
	public void updatePassword(User user) {
		userDao.updatePassword(user);
	}
}
