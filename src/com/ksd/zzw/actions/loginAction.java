package com.ksd.zzw.actions;

import com.ksd.zzw.entity.User;
import com.ksd.zzw.service.UserService;
import com.ksd.zzw.util.UtilMD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Map;

public class loginAction extends ActionSupport {

    private static final long serialVersionUID = 8377030732567144438L;

    @Resource(name = "userService")
    protected UserService userService;

    private String userName;
    private String userPassword;
    private String Code;

    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String login() {
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> map = ac.getSession();
        if (!Code.equals(map.get("Code"))) {
            map.put("message", "验证码输入错误");
            return "login_input";
        }
        userPassword = UtilMD5.MD5(userPassword);
        User user = userService.userLogin(userName, userPassword);
        if (user == null) {
            map.put("message", "账号或密码错误");
            return "login_input";
        } else {
            map.put("user", user);
            return "success";
        }
    }

    public String logout() {
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> map = ac.getSession();
        map.clear();
        return SUCCESS;
    }

    public String modifyPW() throws Exception {
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> map = ac.getSession();
        User user = (User) map.get("user");
        String upw = user.getPassword();
        userPassword = UtilMD5.MD5(userPassword);
        if (upw.equals(userPassword)) {
            newPassword = UtilMD5.MD5(newPassword);
            user.setPassword(newPassword);
            userService.updatePassword(user);
            map.clear();
            map.put("message", "密码已经修改，重新登入");
            return "success";
        } else {
            return "error";
        }
    }
}
