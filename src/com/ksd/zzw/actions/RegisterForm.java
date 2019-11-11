package com.ksd.zzw.actions;

import com.ksd.zzw.entity.User;
import com.ksd.zzw.service.UserService;
import com.ksd.zzw.util.UtilMD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Map;

public class RegisterForm extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -1397533836802060425L;

    @Resource(name = "userService")
    protected UserService userService;

    protected String userName = null;

    protected String userPassword = null;

    protected String email = null;

    protected String Code = null;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @SuppressWarnings("null")
    public String register() {
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> map = ac.getSession();
        if (!Code.equals(map.get("Code"))) {
            map.put("message", "验证码输入错误！");
            return "register_Defeat";
        }
        User user = userService.userIsExit(userName);
        if (user != null) {
            map.put("message", "用户名已经存在！");
            return "register_Defeat";
        }
        userPassword = UtilMD5.MD5(userPassword);
        user = new User(userName,userPassword,email);
        userService.userRegister(userName, userPassword, email);
        map.put("user", user);
        return SUCCESS;
    }
}
