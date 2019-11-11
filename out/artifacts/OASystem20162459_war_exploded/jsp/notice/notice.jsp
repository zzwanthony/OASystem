<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>
<div width="100%" class="right">
    <div class="location">
        <strong>当前位置：</strong>
        <span>公告管理</span>
        <a href="${pageContext.request.contextPath }/UserAdministrator/toNoticeAdd.action?method=toadd">新增公告</a>
    </div>
    <table border="0" width="100%" class="providerTable">
        <tr class="tableheader">
            <th>公告填写人</th>
            <th>公告标题</th>
            <th>公告内容</th>
            <th>公告时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="notice" items="${noticeList }" varStatus="status">
            <tr>
                <td>${notice.sender}</td>
                <td>${notice.title}</td>
                <td>${notice.content}</td>
                <td>${notice.sendtime}</td>
                <td>
                     <span>
                        <a class="modify"
                           href="${pageContext.request.contextPath }/UserAdministrator/toNoticeAdd.action?method=toedit&id=${notice.id}">
                            <img class="imgDel" src="${pageContext.request.contextPath }/static/images/xiugai.png"
                                 alt="修改"
                                 title="修改"/>
                        </a>
                    </span>
                    <span>
                        <a class="delete" href="javascript:;"
                           lir="${pageContext.request.contextPath }/UserAdministrator/toNoticeAdd.action?method=delete&id=${notice.id}">
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
        <form action="${pageContext.request.contextPath }/UserAdministrator/adminSelect.action" method="post">
            <input type="hidden" name="select" value="3">
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
    #liNotice {
        background-color: gray;
    }
</style>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/notice.js"></script>