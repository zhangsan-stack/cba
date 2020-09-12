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
    <title>item_category_second</title>
</head>
<body>
this is item_category_second.jsp
<div >
    <div>
        <ul>
            <a href="#" >新增加二级分类</a>

        </ul>
        <table>
            <tr>
                <th>id</th>
                <th>类别名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${item_categoryList_second}" var = "item_category_second">
                <tr>
                    <td>${item_category_second.id}</td>
                    <td>${item_category_second.name}</td>
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
