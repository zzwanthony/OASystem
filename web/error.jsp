<%--
  Created by IntelliJ IDEA.
  User: 怒斥的安东尼
  Date: 2019/5/31
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Insert title here</title>
<style type="text/css">
    body {
        background-image: url(./static/bgImages/backGround2.jpg);
        background-size: 100% 100%;
        background-attachment: fixed;
        background-color: #CCCCCC;
    }

    img {
        border-radius: 50px;
        background-color: #526A00;
        box-shadow: 10px 10px 10px #526A00,
        10px -10px 10px #526A00,
        -10px 10px 10px #526A00,
        -10px -10px 10px #526A00;
    }
</style>
</head>
<body>
<div style="width: 1000px; margin: 0 auto; margin-top:100px;">
    <a href="${pageContext.request.contextPath }/UserLogin/toLogin" class="returnLogin">
        <img alt="图片" src="${pageContext.request.contextPath }/static/bgImages/backGround9.png">
    </a>
</div>
</body>
</html>
