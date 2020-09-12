<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/4
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>



<html>
<head>
    <title>item_category</title>
</head>
<body>
this is item_category.jsp
<div >
    <div>
        <ul>
            <a href="#" >新增加</a>

        </ul>
        <table>
            <tr>
                <th>id</th>
                <th>类别名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${item_categoryList}" var = "item_category">
                <tr>
                    <td>${item_category.id}</td>
                    <td>${item_category.name}</td>
                    <td>
                        <div>
                            <a href="${pageContext.request.contextPath}/item_category/selectBy_pid?pid=${item_category.id}">查看二级分类</a>
                            <a href="${pageContext.request.contextPath}/item_category/update?id=${item_category.id}">修改</a>
                            <a href="${pageContext.request.contextPath}/item_category/delete?id=${item_category.id}">删除</a>

                        </div>

                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>



</div>


</body>
</html>
