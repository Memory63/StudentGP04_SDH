<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/11/1
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>展示学生信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript">
        function addStudent() {
            window.location = "${pageContext.request.contextPath}/claz/addStudent";
        }
        function updateStudent(id) {
            window.location = "${pageContext.request.contextPath}/claz/updateStudent?id="+id;
        }
    </script>
</head>
<body>
    <span>学生信息</span>
    <hr/>
    <table border="1">
        <c:choose>
            <c:when test="${listStudent!=null}">
                <tr>
                    <td>学生ID</td>
                    <td>学生名字</td>
                    <td>注册时间</td>
                    <td>性别</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${listStudent.getList()}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.username}</td>
                        <td>
                            <fmt:formatDate value="${s.registTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>${s.gender}</td>
                        <td>
                            <button id="add" onclick="addStudent()">增加</button>
                            <button id="update" onclick="updateStudent(${s.id})">修改</button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5">
                        <a href="${pageContext.request.contextPath}/claz/listStudent?pageNum=${listStudent.prePage}&pageSize=${listStudent.pageSize}&clazId=${clazId}">上一页</a> |
                        <c:forEach var="pn" begin="${listStudent.navigateFirstPage }" end="${listStudent.navigateLastPage}" step="1">
                            <a href="${pageContext.request.contextPath}/claz/listStudent?pageNum=${pn}&pageSize=${listStudent.pageSize}&clazId=${clazId}">${pn}</a> |
                        </c:forEach>
                        <a href="${pageContext.request.contextPath}/claz/listStudent?pageNum=${listStudent.nextPage}&pageSize=${listStudent.pageSize}&clazId=${clazId}">上一页</a>
                    </td>
                </tr>
            </c:when>
        </c:choose>
    </table>

</body>
</html>
