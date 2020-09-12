<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/4
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>



<html>
<head>
    <title>main</title>
    <style type="text/css">
        body{
            background-color: grey;
        }
        #readMe{
            width:100%;
            height: 50px;
            color: blue;
            font-size: 30px;
            background: pink;
        }

        #welcome{
            margin: 0;
            padding: 0;
            color: blue;
            font-size: 20px;
            display: inline-block;
            float: right;
        }
        #welcome p{
            margin: 0;
            padding: 0;
        }


    </style>


</head>
<body>
<div id="readMe">
this is main.jsp，管理员后台页面

<h2 id="welcome">
    <c:if test="${sessionScope.manage !=null}">
    <p>热泪欢迎${sessionScope.manage.getUsername()}</p>
    </c:if>
    <c:if test="${sessionScope.manage = null}">
       <a href="/login/goto_adminLogin">请重新登录</a>
    </c:if>
</h2>
    <a href="/login/logout">退出</a>
</div>
<div id="leftNav">
    <span>菜单列表</span>
    <span>基本设置</span>
    <ul>
        <li><a href="${pageContext.request.contextPath}/item_category/selectAll" target="right">类目管理</a> <span></span></li>
        <li><a href="#" target="right"></a> <span>用户管理</span></li>
        <li><a href="${pageContext.request.contextPath}/item/getAll" target="right">商品管理</a> <span></span></li>
        <li><a href="${pageContext.request.contextPath}/item_order/selectAll/" target="right">订单管理</a> <span></span></li>
        <li><a href="${pageContext.request.contextPath}/publicNews/selectAll" target="right">公告管理</a> <span></span></li>
        <li><a href="" target=""></a> <span>留言管理</span></li>

    </ul>

</div>
<ul class="bread">
    <li><a href="" target="right"></a>首页</li>
    <li><a href="">网站信息</a></li>
    <li><b>当前语言</b><span>中文</span></li>

</ul>
<div class="admin">
    <iframe name="right" scrolling="auto" frameborder="0" width="60%" height="60%"></iframe>

</div>


</body>
</html>
