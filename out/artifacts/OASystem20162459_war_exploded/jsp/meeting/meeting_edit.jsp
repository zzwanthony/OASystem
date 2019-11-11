<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>会议管理 >> 会议修改页面</span>
	</div>
	<div class="providerAdd">
		<form id="userForm" name="userForm" method="post"
			  action="${pageContext.request.contextPath }/UserAdministrator/toMeetingAdd.action">
			<input type="hidden" name="method" value="modify">
			<input type="hidden" name="id" value="${meeting.id }"/>
			<input type="hidden" name="sender" value="${user.username }"/>
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div>
				<label>会议开始时间：</label>
				<input type="datetime-local" id="starttime" name="time2"
					   value="<fmt:formatDate value='${meeting.starttime}' pattern='yyyy-MM-dd'/>T<fmt:formatDate value='${meeting.starttime}' pattern='HH:mm:ss'/>"/>
			</div>
			<div>
				<label>会议结束时间：</label>
				<input type="datetime-local" id="endtime" name="time3"
					   value="<fmt:formatDate value='${meeting.endtime}' pattern='yyyy-MM-dd'/>T<fmt:formatDate value='${meeting.endtime}' pattern='HH:mm:ss'/>"/>
			</div>
			<div>
				<label for="address">会议地点：</label>
				<input type="text" name="address" id="address" value="${meeting.address }">
			</div>
			<div>
				<label for="title">会议标题：</label>
				<input type="text" name="title" id="title" value="${meeting.title }">
			</div>
			<div>
				<label for="content">会议内容：</label>
				<textarea name="content" id="content" rows="8" cols="38">${meeting.content}</textarea>
			</div>

			<div class="providerAddBtn">
				<input type="button" name="add" id="add" value="保存">
				<input type="button" id="back" name="back" value="返回">
			</div>
		</form>
	</div>
</div>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/meeting_edit.js"></script>
