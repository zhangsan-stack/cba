<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/3
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminLogin</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>


</head>
<body>
this is adminLogin.jsp
<from >
    <p>管理员登录</p><br>
    用户名：<input type="text" name="username" id="username"><br>
    密码：<input type="text" name="password" id="password"><br>
    <button onclick="confirm_submit()">确定</button>
</from>

<script type="text/javascript">
    function confirm_submit() {

        //暂时不做表单验证，省事

        var username = $("#username").val();
        var password = $("#password").val();

        $.ajax({
            url: "${pageContext.request.contextPath}/login/checkAdminLogin",
            data:{"username": username, "password":password},
            type:"post",
            success:(function (data) {
                console.log(data);
                if(data.code == 100){
                    window.location.href = "${pageContext.request.contextPath}/common/main";
                }else{
                    return false;
                }
            })

        })



    }

</script>

</body>
</html>
