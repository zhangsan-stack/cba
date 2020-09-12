<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/5
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>


<html>
<head>
    <title>item</title>
</head>
<body>
this is item.jsp
<div >
    <div>
        <ul>
            <a href="#" >新增加商品</a>
        </ul>
        <from>
            <input type="text"  placeholder="请输入商品名称" name="name" id="searchName" />
            <a href="javascript:void(0)" onclick="itemSeach()">搜索</a>
        </from>


        <table>
            <tr>
                <th>id</th>
                <th>商品名称</th>
                <th>商品主图</th>
                <th>商品价格</th>
                <th>商品一级分类</th>
                <th>商品二级分类</th>
                <th>操作</th>

                <th>类别名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${itemList}" var = "item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.url1}</td>
                    <td>${item.price}</td>
                    <td>${item.first.name}</td>
                    <td>${item.second.name}</td>
                    <td>
                        <div>
                            <a href="#">修改</a>
                            <a href="#">下架</a>
                        </div>

                    </td>
                </tr>
            </c:forEach>



        </table>

    </div>



</div>



</body>
</html>
