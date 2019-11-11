<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>短消息管理 >> 发送信息页面</span>
	</div>
	<div class="providerAdd">
		<form id="userForm" name="userForm" method="post"
			  action="${pageContext.request.contextPath }/UserAdministrator/toSmsAdd.action">
			<input type="hidden" name="method" value="add">
			<input type="hidden" name="username" value="${user.username }"/>
			<div>
				<label>接收者：</label>
				<input type="text" name="sender" id="sender"/>
			</div>
			<div>
				<label>消息内容：</label>
				<textarea name="message" id="message" rows="8" cols="38"></textarea>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/sms.js"></script>
