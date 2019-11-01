<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/11/1
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript">
        $(function () {
           $("#captcha").blur(function () {
               $.ajax({
                   url:'${pageContext.request.contextPath}/user/captchaCheck',
                   type:'post',
                   data:'code='+$("#captcha").val(),
                   success:function (data) {
                       if(data.code==1){
                           $("#submit").removeAttr("disabled");
                       }else{
                           $("#submit").attr("disabled",true);
                           alert("验证码错误")
                       }
                   }
               });
           })
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
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
            <td><img src="${pageContext.request.contextPath}/captcha"></td>
            <td>
                验证码:
                <input type="text" name="code" id="captcha">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" id="submit" value="登陆" disabled>
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
