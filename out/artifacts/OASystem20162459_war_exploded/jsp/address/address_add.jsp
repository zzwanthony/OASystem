<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>个人通讯录 >> 新建联系人</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post"
              action="${pageContext.request.contextPath }/UserAdministrator/toAddressAdd.action">
            <input type="hidden" name="method" value="add">
            <input type="hidden" name="username" value="${user.username }"/>
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label>姓名：</label>
                <input type="text" name="name" id="name">
            </div>
            <div>
                <label>性别：</label>
                <select name="sex" id="sex">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
            </div>
            <div>
                <label>手机：</label>
                <input type="text" name="mobile" id="mobile">
            </div>
            <div>
                <label>Email：</label>
                <input type="text" name="email" id="email">
            </div>
            <div>
                <label>QQ号码：</label>
                <input type="text" name="qq" id="qq">
            </div>
            <div>
                <label>工作单位：</label>
                <input type="text" name="company" id="company">
            </div>
            <div>
                <label>地址：</label>
                <input type="text" name="address" id="address">
            </div>
            <div>
                <label>邮编：</label>
                <input type="text" name="postcode" id="postcode">
            </div>

            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/address.js"></script>
