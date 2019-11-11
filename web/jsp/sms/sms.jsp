<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>
<div width="100%" class="right">
    <div class="location">
        <strong>当前位置：</strong>
        <span>短信信息管理</span>
        <a href="${pageContext.request.contextPath }/UserAdministrator/toSmsAdd.action?method=toadd">发送信息</a>
    </div>
    <table border="0" width="100%" class="providerTable">
        <tr class="tableheader">
            <th>发送者</th>
            <th>接收人</th>
            <th>短信内容</th>
            <th>发送时间</th>
            <th>是否阅读</th>
            <th>操作</th>
        </tr>
        <c:forEach var="sms" items="${smsList }" varStatus="status">
            <tr>
                <td>${sms.username}</td>
                <td>${sms.sender}</td>
                <td>${sms.message}</td>
                <td>${sms.sendtime}</td>
                <td>
                    <c:choose>
                        <c:when test="${sms.isread == '0'}">未读</c:when>
                        <c:otherwise>已读</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${sms.isread == '0'}">
                        <a href="${pageContext.request.contextPath }/UserAdministrator/toSmsAdd.action?method=modify&id=${sms.id}">设置为已读</a>
                    </c:if>
                    <span>
                        <a class="delete" href="javascript:;"
                           lir="${pageContext.request.contextPath }/UserAdministrator/toSmsAdd.action?method=delete&id=${sms.id}">
                            <img class="imgDel" src="${pageContext.request.contextPath }/static/images/schu.png"
                                 alt="删除"
                                 title="删除"/>
                        </a>
                    </span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div border="0" width="100%" class="pager">
        <!-- 分页显示 -->
        <form action="/UserAdministrator/adminSelect.action" method="post">
            <input type="hidden" name="select" value="5">
            <input type="hidden" name="currentPageNo" value="${currentPageNo}"/>

            <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
            <c:import url="${pageContext.request.contextPath }/jsp/public/rollpage.jsp">
                <c:param name="pageSize" value="${pageSize}"/>
                <c:param name="totalCount" value="${totalCount}"/>
                <c:param name="currentPageNo" value="${currentPageNo}"/>
                <c:param name="totalPageCount" value="${totalPageCount}"/>
            </c:import>
        </form>
    </div>
</div>
<style type="text/css">
    #liSms {
        background-color: gray;
    }
</style>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/sms.js"></script>