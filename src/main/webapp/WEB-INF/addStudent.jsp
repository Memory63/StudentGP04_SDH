<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/11/1
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/claz/addStudent">
        学生姓名:<input type="text" name="username"><br/>
        学生账户密码:<input type="password" name="password"><br/>
        性别:<input type="radio" name="gender" value="男" checked="checked">男
        <input type="radio" name="gender" value="女">女<br/>
        <input type="text" hidden="hidden" name="clazId" value="1">
        <input type="submit" value="提交">
        <input type="reset" value="取消">
    </form>
</body>
</html>
