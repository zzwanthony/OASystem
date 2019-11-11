<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>
<div width="100%" class="right">
    <div class="location">
        <strong>当前位置：</strong>
        <span>日程安排</span>
        <a href="${pageContext.request.contextPath }/UserAdministrator/toScheduleAdd.action?method=toadd">新增日程安排</a>
    </div>
    <table border="0" width="100%" class="providerTable">
        <tr class="tableheader">
            <th>时间</th>
            <th>安排内容</th>
            <th>操作</th>
        </tr>
        <c:forEach var="schdule" items="${scheduleList }" varStatus="status">
            <tr>
                <td>${schdule.scheduleTime}</td>
                <td>${schdule.plan}</td>
                <td>
                    <span>
                        <a class="modify"
                           href="${pageContext.request.contextPath }/UserAdministrator/toScheduleAdd.action?method=toedit&id=${schdule.id}">
                            <img class="imgDel" src="${pageContext.request.contextPath }/static/images/xiugai.png"
                                 alt="修改"
                                 title="修改"/>
                        </a>
                    </span>
                    <span>
                        <a class="delete" href="javascript:;"
                           lir="${pageContext.request.contextPath }/UserAdministrator/toScheduleAdd.action?method=delete&id=${schdule.id}">
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
            <input type="hidden" name="select" value="4">
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
    #liSchedule {
        background-color: gray;
    }
</style>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/schedule.js"></script>