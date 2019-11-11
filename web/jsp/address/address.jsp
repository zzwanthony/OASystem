<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>
<div width="100%" class="right">
    <div class="location">
        <strong>当前位置：</strong>
        <span>个人通讯录</span>
        <a href="${pageContext.request.contextPath }/UserAdministrator/toAddressAdd.action?method=toadd">新增联系人</a>
    </div>
    <table border="0" width="100%" class="providerTable">
        <tr class="tableheader">
            <th>姓名</th>
            <th>性别</th>
            <th>手机</th>
            <th>Email</th>
            <th>QQ号码</th>
            <th>工作单位</th>
            <th>地址</th>
            <th>邮编</th>
            <th>操作</th>
        </tr>
        <c:forEach var="address" items="${addressList }" varStatus="status">
            <tr>
                <td>${address.name}</td>
                <td>
                    <c:if test="${address.sex=='1'}">男</c:if>
                    <c:if test="${address.sex=='2'}">女</c:if>
                </td>
                <td>${address.mobile}</td>
                <td>${address.email}</td>
                <td>${address.qq}</td>
                <td>${address.company}</td>
                <td>${address.address}</td>
                <td>${address.postcode}</td>
                <td>
                    <span>
                        <a class="modify" href="${pageContext.request.contextPath }/UserAdministrator/toAddressAdd.action?method=toedit&id=${address.id}">
                            <img class="imgDel" src="${pageContext.request.contextPath }/static/images/xiugai.png" alt="修改"
                            title="修改"/>
                        </a>
                    </span>
                    <span>
                        <a class="delete" href="javascript:;" lir="${pageContext.request.contextPath }/UserAdministrator/toAddressAdd.action?method=delete&id=${address.id}">
                            <img class="imgDel" src="${pageContext.request.contextPath }/static/images/schu.png" alt="删除"
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
            <input type="hidden" name="select" value="1">
            <input type="hidden" name="currentPageNo" value="${currentPageNo}"/>

            <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
            <c:import url="../public/rollpage.jsp">
                <c:param name="pageSize" value="${pageSize}"/>
                <c:param name="totalCount" value="${totalCount}"/>
                <c:param name="currentPageNo" value="${currentPageNo}"/>
                <c:param name="totalPageCount" value="${totalPageCount}"/>
            </c:import>
        </form>

    </div>
</div>

<style type="text/css">
    #liAddress {
        background-color: gray;
    }
</style>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/address.js"></script>