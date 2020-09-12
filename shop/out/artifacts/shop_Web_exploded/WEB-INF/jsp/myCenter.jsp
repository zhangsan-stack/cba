<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        table td{
            border:1px solid blue;
            width: 150px;
        }
        span{
            margin: 10px 10px ;
            padding: 10px 10px;
        }


    </style>


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
<a href="/login/goto_userIndex" target="_blank" style="color: red">返回用户首页</a>


<div>
    <div id="vipNav">
        <div id="nav_left">
               <ul>
                   <li><a href="">个人信息</a></li>
                   <li><a href="/Goods_trad_record/getMyTradRecord">我的订单</a></li>
                   <li><a href="">商品收藏</a></li>
                   <li><a href="">修改密码</a></li>
               </ul>
        </div>
        <div id="vipRight">
            <form action="">
                <div>基本信息</div>

            </form>

        </div>

    </div>
<p>我的购买记录</p>
    <table>
        <thead>
            <tr>
                <th>商品id</th>
                <th>商品数量</th>
                <th>商品实际价格</th>
                <th>订单号</th>
                <th>支付状态</th>
                <th>下订单时间</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${goods_trad_recordList}" var="goods_trad_record">
                <tr>
                    <td>${goods_trad_record.id}</td>
                    <td>${goods_trad_record.buy_goods_number}</td>
                    <td>${goods_trad_record.realprice}</td>
                    <td>${goods_trad_record.goods_trad_ordercode}</td>
                    <td>${goods_trad_record.status_code}</td>
                    <td>${goods_trad_record.addtime}</td>
                </tr>
            </c:forEach>
        </tbody>


    </table>


</div>
<div>
    <div>
        <span>全部订单 ${fn:length(goods_trad_recordList_all)}</span>
        <span>已经支付</span>
        <span>发货中</span>
        <span>收到货物</span>
    </div>


</div>




</body>
</html>
