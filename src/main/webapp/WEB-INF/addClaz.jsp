<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/11/1
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加班级</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/claz/add">
        班级名称:<input type="text" name="clazName"><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
