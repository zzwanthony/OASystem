<%--
  Created by IntelliJ IDEA.
  User: 怒斥的安东尼
  Date: 2019/5/29
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>OA管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/public.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>OA系统</h1>
    <div class="publicHeaderR">
        <div>
            <span>您好！</span>
            <div class="userTitle">
                ${user.username }
                <div class="getUser">
                    <p>你的信息</p>
                    <p>账号：${user.username }</p>
                    <p>Email：${user.email }</p>
                    <p>
                        <button id="mimaXG">修改密码</button>
                    </p>
                </div>
            </div>
            , 欢迎你！
            <a href="${pageContext.request.contextPath }/UserLogin/logout">退出</a>
        </div>
    </div>
</header>
<!--点击修改密码后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>修改密码</h2>
        <div class="removeMain">
            <p>
                <label>原密码：</label>
                <input type="password" id="oldPassword">
                <input type="hidden" id="userPWD" value="${user.password}">
            </p>
            <p>
                <label>新密码：</label>
                <input type="password" id="newPassword">
            </p>
            <p>
                <label>确定密码：</label>
                <input type="password" id="newPassword2">
            </p>
            <p style="color: red"></p>
            <a href="#" id="yes">修改</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>
<!--时间-->
<section class="publicTime">
    <span id="time">2019年1月1日  11:11  星期一</span>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li id="liMain"><a
                        href="${pageContext.request.contextPath }/UserAdministrator/adminSelect?select=0&currentPageNo=1">首页面</a>
                </li>
                <li id="liAddress"><a
                        href="${pageContext.request.contextPath }/UserAdministrator/adminSelect?select=1&currentPageNo=1">个人通讯录</a>
                </li>
                <li id="liMeeting"><a
                        href="${pageContext.request.contextPath }/UserAdministrator/adminSelect?select=2&currentPageNo=1">会议管理</a>
                </li>
                <li id="liNotice"><a
                        href="${pageContext.request.contextPath }/UserAdministrator/adminSelect?select=3&currentPageNo=1">公告管理</a>
                </li>
                <li id="liSchedule"><a
                        href="${pageContext.request.contextPath }/UserAdministrator/adminSelect?select=4&currentPageNo=1">日程安排</a>
                </li>
                <li id="liSms"><a
                        href="${pageContext.request.contextPath }/UserAdministrator/adminSelect?select=5&currentPageNo=1">短信消息管理</a>
                </li>
                <li id="liWorklog"><a
                        href="${pageContext.request.contextPath }/UserAdministrator/adminSelect?select=6&currentPageNo=1">工作日志</a>
                </li>
                <li><a href="${pageContext.request.contextPath }/UserLogin/logout">退出系统</a></li>
            </ul>
        </nav>
    </div>