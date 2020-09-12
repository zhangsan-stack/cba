<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/6
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>item_order</title>
</head>
<body>
this is item_order.jsp
<div >
    <div>
        <ul>
            <a href="#" >新增加</a>

        </ul>
        <table>
            <tr>
                <th>商品id</th>
                <th>用户名</th>
                <th>订单号</th>
                <th>总价</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${item_orderList}" var = "item_order">
                <tr>
                    <td>${item_order.item_id}</td>
                    <td>${item_order.user.username}</td>
                    <td>${item_order.ordercode}</td>
                    <td>${item_order.total}</td>
                    <td>
                        <c:if test="${item_order.status == 0}">代发货</c:if>
                        <c:if test="${item_order.status == 1}">已经取消</c:if>
                        <c:if test="${item_order.status == 2}">待收货</c:if>
                        <c:if test="${item_order.status == 3}">已经收货</c:if>

                    </td>
                    <td>
                        <div>

                        </div>

                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>



</div>


</body>
</html>
