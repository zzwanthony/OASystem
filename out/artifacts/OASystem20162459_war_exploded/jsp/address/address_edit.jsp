<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../public/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>个人通讯录 >> 修改联系人</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post"
              action="${pageContext.request.contextPath }/UserAdministrator/toAddressAdd.action">
            <input type="hidden" name="method" value="modify">
            <input type="hidden" name="id" value="${address.id }"/>
            <input type="hidden" name="username" value="${address.username }"/>
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="name">姓名：</label>
                <input type="text" name="name" id="name" value="${address.name }">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="sex">性别：</label>
                <select name="sex" id="sex">
                    <c:choose>
                        <c:when test="${address.sex == '1' }">
                            <option value="1" selected="selected">男</option>
                            <option value="2">女</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">男</option>
                            <option value="2" selected="selected">女</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div>
                <label for="mobile">手机：</label>
                <input type="text" name="mobile" id="mobile" value="${address.mobile }">
                <font color="red"></font>
            </div>
            <div>
                <label for="email">Email：</label>
                <input type="text" name="email" id="email" value="${address.email }">
                <font color="red"></font>
            </div>
            <div>
                <label for="qq">QQ号码：</label>
                <input type="text" name="qq" id="qq" value="${address.qq }">
                <font color="red"></font>
            </div>
            <div>
                <label for="company">工作单位：</label>
                <input type="text" name="company" id="company" value="${address.company }">
                <font color="red"></font>
            </div>
            <div>
                <label for="address">地址：</label>
                <input type="text" name="address" id="address" value="${address.address }">
                <font color="red"></font>
            </div>
            <div>
                <label for="postcode">邮编：</label>
                <input type="text" name="postcode" id="postcode" value="${address.postcode }">
            </div>

            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
<%@include file="../public/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/address_edit.js"></script>
