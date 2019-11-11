package com.ksd.zzw.Interceptor;

import com.ksd.zzw.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class LoggingInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取用户是否登录
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null){
			//已登录放行
			return invocation.invoke();
		}
//        Integer len = ServletActionContext.getRequest().getRequestURL().length();
//        Integer len2 = ServletActionContext.getRequest().getRequestURI().length();
//        System.out.println(len);
//        System.out.println(len2);
//        String url = ServletActionContext.getRequest().getRequestURL().substring(0,len-len2);
//        System.out.println(url);
		//未登录，跳转到登录页面使其登录
		return "toLogin";
	}
}
