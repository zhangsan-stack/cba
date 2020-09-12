<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/6
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order_detail</title>
</head>
<body>
order_detail

<div >
    <div>
        <table>
            <tr>
                <th>id</th>
                <th>类别名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${order_detailList}" var = "order_detail">
                <tr>
                    <td>${order_detail.item.id}</td>
                    <td>${order_detail.item.price}</td>
                    <td>${order_detail.num}</td>
                    <td>${order_detail.total}</td>
                    <td>
                        <c:if test="${order_detail.status == 0}">未退货</c:if>
                        <c:if test="${order_detail.status == 1}">已退货</c:if>
                    </td>
                    <td>
                        <div>
                            <a href="#">修改</a>
                            <a href="#">删除</a>

                        </div>

                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>




</body>
</html>
