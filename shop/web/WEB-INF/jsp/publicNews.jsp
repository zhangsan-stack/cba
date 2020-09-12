<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>publicNews</title>
</head>
<body>
this is publicNews

<div >
    <div>
        <ul>
            <a href="#" >新增加二级分类</a>

        </ul>
        <table>
            <tr>
                <th>id</th>
                <th>类别名称</th>
                <th>发表时间</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${newsList}" var = "news">
                <tr>
                    <td>${news.name}</td>
                    <td>${news.content}</td>
                    <td><fmt:formatDate value="${news.addtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                    <td>
                        <div>
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
