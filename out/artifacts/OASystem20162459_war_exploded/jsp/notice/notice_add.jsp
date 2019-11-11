<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>公告管理 >> 新增公告页面</span>
	</div>
	<div class="providerAdd">
		<form id="userForm" name="userForm" method="post"
			  action="${pageContext.request.contextPath }/UserAdministrator/toNoticeAdd.action">
			<input type="hidden" name="method" value="add">
			<input type="hidden" name="sender" value="${user.username }"/>
			<div>
				<label for="title">公告标题：</label>
				<input type="text" name="title" id="title" value="">
				<font color="red"></font>
			</div>
			<div>
				<label for="content">公告内容：</label>
				<textarea name="content" id="content" rows="8" cols="38"></textarea>
				<font color="red"></font>
			</div>

			<div class="providerAddBtn">
				<input type="button" name="add" id="add" value="保存">
				<input type="button" id="back" name="back" value="返回">
			</div>
		</form>
	</div>
</div>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/notice.js"></script>
