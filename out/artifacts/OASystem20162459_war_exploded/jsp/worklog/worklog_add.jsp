<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>工作日志 >> 添加工作日志页面</span>
	</div>
	<div class="providerAdd">
		<form id="userForm" name="userForm" method="post"
			  action="${pageContext.request.contextPath }/UserAdministrator/toWorklogAdd.action">
			<input type="hidden" name="method" value="add">
			<input type="hidden" name="username" value="${user.username }"/>
			<div>
				<label>时间：</label>
				<%--<input type="text" Class="Wdate" id="workTime" name="workTime" value="" readonly="readonly" onclick="WdatePicker();">--%>
				<input type="datetime-local" id="workTime"  name="time2"/>
			</div>
			<div>
				<label>标题：</label>
				<input type="text" name="title" id="title"/>
			</div>
			<div>
				<label>内容：</label>
				<textarea name="description" id="description" rows="8" cols="38"></textarea>
			</div>

			<div class="providerAddBtn">
				<input type="button" name="add" id="add" value="保存">
				<input type="button" id="back" name="back" value="返回">
			</div>
		</form>
	</div>
</div>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/worklog.js"></script>
