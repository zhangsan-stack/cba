<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>keywordsResult</title>
    <style type="text/css">

        #top{

            width: 100%;
            height: 40px;
            background-color: grey;
        }
        p{
            display: inline-block;
            float: left;
            text-align: center;
        }
        .welcome {
            display: inline-block;
            float: right;
        }
        .search{
            display: inline-block;
            float: right;
        }
        #leftNav{

            width: 200px;
            height: 500px;
            font-size: 30px;

            float:left;
            display: inline-block;
        }
        #banner{
            float:left;
            display: inline-block;

        }
        #bigTable{
            margin: 20px 20px;
            width: 50%;
            height: 100%;
            display: block;
            float: left;

        }
        #smallTable{
            margin: 20px 20px;
            width: 50%;
            height: 100%;
            display: block;
            float: left;

        }
        table {

            font-size: 20px;
            border-collapse: collapse;
            border-spacing: 1px;

        }
        table td{
            border:1px solid blue;
            width: 150px;
        }



    </style>

    <style>
        h1, h2, h3, h4, h5, h6, hr, p, blockquote, dl, dt, dd, ul, ol, li, pre, form, fieldset, legend, button,  textarea, th, td { margin:0; padding:0;border:none;list-style:none; }
        #banner{ width:662px; height:300px; margin:45px 45px ; position:relative; overflow:hidden;}
        #banner #picUl li{ position:absolute; top:0; left:0;}
        #banner #picUl li img{ width:600px;}
        #banner #tab{ width:62px; height:100%; position:absolute; right:0; background:#000;}
        #banner #tab li { width:62px;text-align:center; position:relative;}
        #banner #tab li a{ text-decoration:none; color:#fff; font-size:15px;line-height:50px; display:block;}
        #banner #tab li span{
            width: 0;
            height: 0;
            display: block;
            position: absolute;
            top: 50%;
            left:-15px;
            margin-top:-3px;
            border-width: 8px;
            border-style: solid;
            border-color: transparent rgba(255,0,0,0.6) transparent transparent;
            display:none;
        }
        #banner #tab li.active{ background:rgba(255,0,0,0.6);}
        #banner #tab li.active .on{ display:block;}
    </style>



    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>


</head>
<body>
this is userIndex.jsp


<div id="top">
    <p>欢迎来到水果蔬菜商城</p>
    <div class="welcome">

        <c:if test="${sessionScope.user != null}">
            <p>热泪欢迎${sessionScope.user.username}</p>&nbsp;
            <a href="#">退出</a>&nbsp;
            <a href="/cart//goto_myCartJSP">我的购物车</a>&nbsp;
            <a href="${pageContext.request.contextPath}/userLogin/myCenter?buyer_id=${sessionScope.user.id}">个人中心</a>&nbsp;
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <a href="${pageContext.request.contextPath}/userLogin/goto_userLoginJSP">登录</a>&nbsp;&nbsp;
            <a href="#">注册</a>&nbsp;
        </c:if>
        &nbsp;<a href="/shopkeeper/goto_shopkeeperJSP">去商家界面</a>&nbsp;&nbsp;
    </div>
    <div class="search">
        <div>
            <div>
                <form id="searchForm01"  action="/Goods/fuzzy_query" method="post">
                    <input type="text" placeholder="关键字查询" class="" name="keywords" >
                    <input type="submit" class="" value="搜索">
                </form>
            </div>
        </div>
    </div>
</div>
<div>
    <div id="leftNav">
        <span>菜单列表</span>
        <span>基本设置</span>
        <a>首页</a>
        <a>公告</a>
        <a>留言</a>
        <ul>
            <li><a href="#" target="right">类目管理</a> <span></span></li>
            <li><a href="#" target="right"></a> <span>用户管理</span></li>
            <li><a href="#" target="right">商品管理</a> <span></span></li>
            <li><a href="#" target="right">订单管理</a> <span></span></li>
            <li><a href="#" target="right">公告管理</a> <span></span></li>
            <li><a href="#" target=""></a> <span>留言管理</span></li>

        </ul>
    </div>


    <div id="banner">
        <div id="pic">
            <ul id="picUl">
                <li><a href="#"><img src="../resources/img/b1.jpg"></a></li>
                <li><a href="#"><img src="../resources/img/b2.jpg"></a></li>
                <li><a href="#"><img src="../resources/img/b3.jpg"></a></li>
                <li><a href="#"><img src="../resources/img/b4.jpg"></a></li>
                <li><a href="#"><img src="../resources/img/b5.jpg"></a></li>
                <li><a href="#"><img src="../resources/img/b6.jpg"></a></li>
            </ul>
        </div>
        <div id="tab">
            <ul id="tabUl">
                <li class="active"><a href="#">要闻</a><span class="on"></span></li>
                <li><a href="#">社会</a><span></span></li>
                <li><a href="#">娱乐</a><span></span></li>
                <li><a href="#">体育</a><span></span></li>
                <li><a href="#">军事</a><span></span></li>
                <li><a href="#">明星</a><span></span></li>
            </ul>
        </div>
    </div>

</div>

<br>

<div id="">
    <table>
        <thead>
        <tr>
            <th>商品名称</th>
            <th>商品价格（元/千克）</th>
            <th>商品图片</th>
            <th>操作</th>
        </tr>

        </thead>

        <tbody>
        <c:forEach items="${goodsList_by_keywords}" var="goods">
            <tr>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td>${goods.image}</td>
                <td>
                    <a href="javascript:void(0)" onclick="addIntoCart(${goods.id},${goods.price})">加入购物车</a>
                    <a >收藏</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>






<script type="text/javascript">
    function confirm_submit() {

        //暂时不做表单验证，省事

        var username = $("#username").val();
        var password = $("#password").val();

        $.ajax({
            url: "${pageContext.request.contextPath}/userLogin/check_userLogin",
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

<script>

    //这个函数里面，把商品的数量写成固定值了，以后可以修改
    function addIntoCart(goods_id, price) {
        $.ajax({
            url:"${pageContext.request.contextPath}/cart/addIntoCart",
            data:{"goods_id":goods_id, "num" : 1,"price": price },
            type:"post",
            success:function (result) {
                alert("加入成功");
            }
        })
    }

</script>

<script type="text/javascript">
    $(function(){
        var timer=null;
        var index=0;
        var picLi=$("#banner #picUl li");
        var tabLi=$("#banner #tabUl li" );
        var tabSp=$("#banner #tabUl li span")
        var size=$("#banner #picUl li").size();
        tabLi.mouseover(function(){
            index=$(this).index();
            $(this).addClass('active').siblings().removeClass('active');
            tabSp.eq(index).addClass('on').siblings().removeClass('on');
            picLi.eq(index).fadeIn().siblings().fadeOut();
        });
        $("#picUl").hover(function(){
            clearInterval(timer);
        },function(){timer=setInterval(move,1500);});
        window.clearInterval(timer);
        timer=window.setInterval(move,1500);
        function move(){
            index++;
            if(index==size)
            {
                index=0;
            }
            tabLi.eq(index).addClass('active').siblings().removeClass('active');
            tabSp.eq(index).addClass('on').siblings().removeClass('on');
            picLi.eq(index).fadeIn().siblings().fadeOut();
        }
    })
</script>

</body>
</html>
