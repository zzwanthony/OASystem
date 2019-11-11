<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>日程安排 >> 新增日程安排页面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post"
              action="${pageContext.request.contextPath }/UserAdministrator/toScheduleAdd.action">
            <input type="hidden" name="method" value="modify">
            <input type="hidden" name="id" value="${schedule.id }"/>
            <input type="hidden" name="username" value="${user.username }"/>
            <div>
                <label>时间：</label>
                <%--<input type="text" Class="Wdate" id="scheduleTime" name="scheduleTime" value="${schedule.scheduleTime}" readonly="readonly" onclick="WdatePicker();">--%>
                <input type="datetime-local" id="scheduleTime" name="time2"
                       value="<fmt:formatDate value='${schedule.scheduleTime}' pattern='yyyy-MM-dd'/>T<fmt:formatDate value='${schedule.scheduleTime}' pattern='HH:mm:ss'/>"/>
            </div>
            <div>
                <label>事务安排：</label>
                <textarea name="plan" id="plan" rows="8" cols="38">${schedule.plan}</textarea>
            </div>

            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/schedule_edit.js"></script>
