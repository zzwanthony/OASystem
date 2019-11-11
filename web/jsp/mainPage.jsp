<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="./public/head.jsp"%>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath }/static/images/bird.gif"/>
        <div class="wFont">
            <h2 style="color: white;">${user.username }</h2>
            <p style="color: white;">欢迎来到OA管理系统!</p>
        </div>
       	<img alt="laugth" src="${pageContext.request.contextPath }/static/images/facePicture.png">
    </div>
</section>
<%@include file="./public/foot.jsp" %>
