<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="page-bar">
    <ul class="page-num-ul clearfix">
        <li>每页记录数：
            <select name="pageSize" onchange="page_change(document.forms[0]);">
                <option value="5"
                        <c:if test="${pageSize==5}">selected="selected"</c:if> >5
                </option>
                <option value="7"
                        <c:if test="${pageSize==7}">selected="selected"</c:if> >7
                </option>
                <option value="10"
                        <c:if test="${pageSize==10}">selected="selected"</c:if> >10
                </option>
                <option value="12"
                        <c:if test="${pageSize==12}">selected="selected"</c:if> >12
                </option>
                <option value="15"
                        <c:if test="${pageSize==15}">selected="selected"</c:if> >15
                </option>
                <option value="20"
                        <c:if test="${pageSize==20}">selected="selected"</c:if> >20
                </option>
            </select>
        </li>
        <li>共${param.totalCount }条记录&nbsp;&nbsp; ${param.currentPageNo }/${param.totalPageCount }页</li>
        <c:if test="${param.currentPageNo > 1}">
            <a href="javascript:page_nav(document.forms[0],1);">&nbsp;&nbsp;首&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1 });">&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
        </c:if>
        <c:if test="${param.currentPageNo < param.totalPageCount }">
            <a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1 });">&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a href="javascript:page_nav(document.forms[0],${param.totalPageCount });">&nbsp;&nbsp;最后一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
        </c:if>
        &nbsp;&nbsp;
    </ul>
    <div class="page-go-form">
        <div style="display:inline-block;padding-top:10px;">
            <label>跳转至</label>
            <input type="text" id="inputPage" class="page-key" style="color:white;"/>页
        </div>
        <button type="button" class="page-btn"
                onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'></button>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/rollpage.js"></script>
</html>