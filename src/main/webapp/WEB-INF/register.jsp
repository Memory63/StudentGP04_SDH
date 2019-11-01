<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/11/1
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#role").change(function () {
                if($(this).val()==2){
                    $("#claz").show();
                }else{
                    $("#claz").hide();
                }
            })
        })
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/register" method="post">
        <table border="1">
            <tr>
                <td>用户名:</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <input type="radio" name="gender" value="男" checked="checked">男
                    <input type="radio" name="gender" value="女">女
                </td>
            </tr>
            <tr>
                <td>角色:</td>
                <td>
                    <select name="roleId" id="role">
                        <c:forEach var="r" items="${roles}" varStatus="vs">
                            <option value="${r.id}">${r.roleName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr id="claz" hidden="hidden">
                <td>班级:</td>
                <td>
                    <select name="clazId">
                        <c:forEach var="c" items="${clazs}">
                            <option value="${c.id}">${c.clazName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="注册">
                    <input type="reset" value="取消">
                </td>
            </tr>

        </table>
    </form>
</body>
</html>
