
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/7
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myCenter</title>

    <style>
        #nav_left{
            float: left;
            display: inline-block;
        }
        #vipRight{
            float: left;
            display: inline-block;
        }


    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>


</head>
<body>
this is myCenter.jsp
<div class="welcome">

    <c:if test="${sessionScope.user != null}">
        <p>热泪欢迎${sessionScope.user.username}</p>
        <a href="#">退出</a>
        <a href="#">我的购物车</a>
        <a href="#">个人中心</a>
    </c:if>
    <c:if test="${sessionScope.user == null}">
        <a href="${pageContext.request.contextPath}/userLogin/goto_userLoginJSP">登录</a>
        <a href="#">注册</a>
    </c:if>

</div>
<div>当前位置，我的购物车
<a href="/login/goto_userIndex" target="_blank" style="color: red">返回用户首页</a>
</div>
<div>
    <div id="vipNav">
        <div id="nav_left">
            <ul>
                <li><a href="">个人信息</a></li>
                <li><a href="/item_order/my">我的订单</a></li>
                <li><a href="">商品收藏</a></li>
                <li><a href="">修改密码</a></li>
            </ul>
        </div>
    </div>
<div>
    全部商品

    <table>
        <thead>
            <tr>
                <th>商品id</th>
                <th>商品数量</th>
                <th>商品单价</th>
                <th>商品总价</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cartList}" var="cart">
                <tr>
                    <td>${cart.goods_id}</td>
                    <td>${cart.num}</td>
                    <td>${cart.price}</td>
                    <td>${cart.total_price}</td>

                    <%--这里可以把该条数据的id传给后台，在用来结算后，删除该条数据--%>
                    <td><a href="javascript:void(0)" goodsid="${cart.goods_id}" goodsprice="${cart.price}" cartid="${cart.id}"  onclick="countMoney(${cart.goods_id},${cart.price}, ${cart.id})">结算</a></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>

</div>
<script>
    function countMoney(goodsid, goodsprice,cartid) {
        alert(goodsid);
        alert(goodsprice);
        $.ajax({
            url:"${pageContext.request.contextPath}/shopkeeper/I_want_buy",
            data:{"goodsid":goodsid,"goodsprice":goodsprice, "cartid": cartid},
            type:"post",
            success:function(result){
                if(result == "success"){
                    alert("result");
                    //从定向到购
                    window.location.href = "${pageContext.request.contextPath}/cart/goto_myCartJSP";
                }

            }
        })
    }

</script>

</body>
</html>
