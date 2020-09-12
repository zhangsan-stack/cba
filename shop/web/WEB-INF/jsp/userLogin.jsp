<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/7
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userLogin</title>
</head>
<body>
this is uerLogin.jsp

<div>
    <form action="${pageContext.request.contextPath}/userLogin/check_userLogin">
        <p>用户登录</p><br>
        用户名：<input type="text" name="username" id="username"><br>
        密码：<input type="text" name="password" id="password"><br>
        <img src="${pageContext.request.contextPath}/userLogin/getCheckCode" width="100px" height="50px"><br>
        验证码&nbsp;：<input type="text" id="checkCode" name="checkCode">
        <input type="submit" value="确定">
    </form>
</div>




</body>
</html>
