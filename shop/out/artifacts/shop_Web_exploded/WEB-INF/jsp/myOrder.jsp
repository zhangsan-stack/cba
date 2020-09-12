<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/7
  Time: 21:22
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

        #show_all{
            display:none;
        }
        #show_status_code_0{
            display:none;
        }
        #show_status_code_1 {
          display:none;
        }
        #show_status_code_2 {
         display:none;
        }
        #show_status_code_3 {
            display:none;
        }
    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script>
    //立即执行函数
    $(function(){
        $(".showCommand").click(function(){
            var index = $(this).index();
            $(".showMyOrder").hide();
            $(".showMyOrder:eq("+index+")").show();
        })
    })

    </script>



</head>
<body>
this is myOrder.jsp
<div class="welcome">

    <c:if test="${sessionScope.user != null}">
        <p>热泪欢迎${sessionScope.user.username}</p>
        <a href="#">退出</a>
        <a href="#">我的购物车</a>

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
                <li><a href="${pageContext.request.contextPath}/userLogin/myCenter">个人信息</a></li>
                <li><a href="">我的订单</a></li>
                <li><a href="">商品收藏</a></li>
                <li><a href="">修改密码</a></li>
            </ul>
        </div>

    </div>

    <table>
        <thead>
            <tr>
                <th>所有订单</th>
                <th>已经支付</th>
                <th>发货中</th>
                <th>收到货物</th>
            </tr>
        </thead>

        <tbody>

        </tbody>
    </table>



</div>
<div>
    <div>
        &nbsp;&nbsp;<a href="javascript:void(0)"  class="showCommand" >全部订单(${fn:length(goods_trad_recordList_all)})</a>&nbsp;
        &nbsp;<a href="javascript:void(0)"  class="showCommand">已经支付(${fn:length(goods_trad_recordList_0)})</a>&nbsp;
        &nbsp;<a href="javascript:void(0)"  class="showCommand">发货中(${fn:length(goods_trad_recordList_1)})</a>&nbsp;
        &nbsp; <a href="javascript:void(0)"  class="showCommand">收到货物(${fn:length(goods_trad_recordList_2)})</a>&nbsp;
        &nbsp; <a href="javascript:void(0)"  class="showCommand">测试专用(${fn:length(goods_trad_recordList_3)})</a>&nbsp;

    </div>
   <%-- 全部订单--%>
    <div id="show_all" class="showMyOrder">
        <table>
            <thead></thead>
            <tbody>
            <c:forEach items="${goods_trad_recordList_all}" var="goods_trad_record">
                <tr>
                    <td> 订单号：${goods_trad_record.goods_trad_ordercode} 时间：${goods_trad_record.addtime}   </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>
<br>
    <div id="show_status_code_0"  class="showMyOrder">
        <table>
            <thead></thead>
            <tbody>
            <c:forEach items="${goods_trad_recordList_0}" var="goods_trad_record">
                <tr>
                    <td> 订单号：${goods_trad_record.goods_trad_ordercode} 时间：${goods_trad_record.addtime} </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>

<br>
    <div id="show_status_code_1"  class="showMyOrder">
        <table>
            <thead></thead>
            <tbody>
            <c:forEach items="${goods_trad_recordList_1}" var="goods_trad_record">
                <tr>
                    <td> 订单号：${goods_trad_record.goods_trad_ordercode} 时间：${goods_trad_record.addtime} </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>
<br>
    <div id="show_status_code_2"  class="showMyOrder">
        <table>
            <thead></thead>
            <tbody>
            <c:forEach items="${goods_trad_recordList_2}" var="goods_trad_record">
                <tr>
                    <td> 订单号：${goods_trad_record.goods_trad_ordercode} 时间：${goods_trad_record.addtime} </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>
<br>
    <div id="show_status_code_3"  class="showMyOrder">
        <table>
            <thead></thead>
            <tbody>
            <c:forEach items="${goods_trad_recordList_3}" var="goods_trad_record">
                <tr>
                    <td> 订单号：${goods_trad_record.goods_trad_ordercode} 时间：${goods_trad_record.addtime}</td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>




</div>




</body>
</html>
