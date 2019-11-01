<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/11/1
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>班级列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript">
        function showClaz(id) {
            window.location="${pageContext.request.contextPath}/claz/listStudent?clazId="+id;
        }
    </script>
</head>
<body>
    <span>班级信息列表</span>
    <span>
        欢迎：<shiro:principal></shiro:principal> |
        <a href="${pageContext.request.contextPath}/user/logout">退出</a>
    </span>
    <hr/>
    <table border="1">
        <c:choose>
            <c:when test="${listClaz.size()!=0}">
                <tr>
                    <td>班级ID</td>
                    <td>班级名字</td>
                    <td>班级创建时间</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${listClaz}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.clazName}</td>
                        <td>
                            <fmt:formatDate value="${c.crateTime}" type="time" pattern="yyyy-MM-dd" ></fmt:formatDate>
                        </td>

                        <td>
                            <button id="show" onclick="showClaz(${c.id})">查看</button>
                        </td>

                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
</body>
</html>
