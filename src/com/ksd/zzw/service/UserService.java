package com.ksd.zzw.service;

import com.ksd.zzw.entity.User;

public interface UserService {
    public User userLogin(String username, String password);

	public void userRegister(String userName, String userPassword, String email);

	public User userIsExit(String userName);

    void updatePassword(User user);
}
