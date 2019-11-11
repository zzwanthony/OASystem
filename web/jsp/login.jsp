<%--
  Created by IntelliJ IDEA.
  User: 怒斥的安东尼
  Date: 2019/5/29
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is login page">
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        body {
            width: 100%;
            height: 100vh;
            font-family: "微软雅黑";
            overflow: hidden;
        }

        #center {
            width: 280px;
            margin: 200px auto 0;
        }

        #f_phone {
            position: relative;
        }

        #getMessage {
            position: absolute;
            top: 5px;
            right: 10px;
            width: 100px;
            height: 30px;
            background: rgba(255, 255, 255, .5);
            text-align: center;
            line-height: 30px;
            cursor: pointer;
            font-size: 12px;
            color: #333;
            user-select: none;
        }

        #getMessage:hover {
            background: rgba(255, 255, 255, .8);
        }

        #getMessage:active {
            background: rgba(0, 0, 0, .5);
            color: #fff;
        }

        #Code, #userName, #userPassword {
            width: 280px;
            height: 40px;
            text-indent: 16px;
            color: #fff;
            background: rgba(3, 3, 3, .3);
            outline: none;
            border: 1px solid rgba(33, 33, 33, .2);
        }

        #Code {
            border-bottom: none;
        }

        #userPassword {
            border-top: 1px solid rgba(0, 0, 0, .4);
        }

        #btn {
            margin-top: 30px;
            width: 280px;
            height: 40px;
            text-align: center;
            line-height: 40px;
            color: #FFFFFF;
            background: rgba(3, 3, 3, .5);
            transition: .3s;
            cursor: pointer;
        }

        #btn:hover {
            background: #333;
        }

        #center p {
            margin-top: 10px;
        }

        #center a {
            text-decoration: none;
            color: #fff;
            font-size: 14px;
        }

        #center a i {
            font-size: 14px;
            margin-right: 4px;
        }

        #center .register {
            float: left;
            margin-left: 10px;
        }
    </style>
    <script type="text/javascript">
        function changeImg(img) {
            img.src = "${pageContext.request.contextPath }/UserLogin/ValiImage?time=" + new Date().getTime();
        }

        function login() {
            var userName = $("#userName");
            var userPassword = $("#userPassword");
            var Code = $("#Code");
            if (userName.val() == "" || userName.val() == null) {
                alert("请输入账号！");
                $("#userName").focus();
            } else if (Code.val() == "" || Code.val() == null) {
                alert("请输入验证码！");
                $("#Code").focus();
            } else if (userPassword.val() == "" || userPassword.val() == null) {
                alert("请输入密码！");
                $("#userPassword").focus();
            } else {
                $('#actionForm').submit()
            }
        }
    </script>
</head>
<body>

<div id="center">
    <form id="actionForm" action="${pageContext.request.contextPath }/UserLogin/login.action" method="post">
        <input type="text" name="userName" id="userName" autocomplete="off" class="animated bounceInRight"
               placeholder="请输入账号"/>
        <input type="password" name="userPassword" id="userPassword" autocomplete="off" class="animated bounceInRight"
               placeholder="请输入密码"/>
        <div id="f_phone" class="animated bounceInLeft">
            <input type="text" name="Code" id="Code" autocomplete="off" placeholder="请输入验证码"/>
            <img id="getMessage" alt="验证码" src="${pageContext.request.contextPath }/UserLogin/ValiImage.action"
                 style="cursor: pointer;" onclick="changeImg(this)">
        </div>
        <p id="m' essage" style="color:red">${message }</p>
        <div id="btn" class="animated zoomIn" onclick="login()">登录</div>
    </form>
    <p class="animated bounceInDown">
        <a href="${pageContext.request.contextPath }/UserLogin/toRegister.action" class="register"><i
                class="iconfont icon-icoreg"></i>注册</a>
    </p>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bg.js"></script>
</body>
</html>
