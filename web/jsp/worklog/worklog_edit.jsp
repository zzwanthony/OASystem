<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>工作日志 >> 修改工作日志页面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post"
              action="${pageContext.request.contextPath }/UserAdministrator/toWorklogAdd.action">
            <input type="hidden" name="method" value="modify">
            <input type="hidden" name="id" value="${worklog.id }"/>
            <input type="hidden" name="username" value="${user.username }"/>
            <input type="hidden" name="logtime" value="${worklog.logtime }"/>
            <div>
                <label>时间：</label>
                <input type="datetime-local" id="workTime" name="time2"
                       value="<fmt:formatDate value='${worklog.workTime}' pattern='yyyy-MM-dd'/>T<fmt:formatDate value='${worklog.workTime}' pattern='HH:mm:ss'/>"/>
            </div>
            <div>
                <label>标题：</label>
                <input type="text" name="title" id="title" value="${worklog.title }"/>
            </div>
            <div>
                <label>内容：</label>
                <textarea name="description" id="description" rows="8" cols="38">${worklog.description }</textarea>
            </div>

            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/worklog_edit.js"></script>
