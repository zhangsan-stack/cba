<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<html>
<head>
    <title>shopkeeper</title>

    <Style type="text/css">
        ul li{
            width: 60px;
            float: left;
        }

    </Style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>


</head>
<body>
this is shopkeeper
<a href="/login/goto_userIndex" target="_blank" style="color: red">返回用户首页</a>

<%--<table>
    <thead>
    <tr>
        <th>商家姓名</th>
        <th>订单号</th>
        <th>买家id</th>
        <th>余额</th>
        <th>交易时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${shopkeeperList01}" var="shopkeeper">
        <tr>
            <td>${shopkeeper.keepername}</td>
            <td>${shopkeeper.exchange_id}</td>
            <td>${shopkeeper.buyerid}</td>
            <td>${shopkeeper.keepercount}</td>
            <td><fmt:formatDate value="${shopkeeper.exchange_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>

        </tr>
    </c:forEach>
    </tbody>

</table>--%>

    <%--<pg:pager url="${pageContext.request.contextPath}/shopkeeper/goto_shopkeeperJSP"  maxIndexPages ="10" items="25" maxPageItems="15" export="currentPageNumber=pageNumber">
        <pg:last>
            总共${pageInfos.total}页, 当前是第${pageNumber}页，
        </pg:last>
        当前${curPage}
        <pg:first>
            <a href="${pageUrl}">首页</a>
        </pg:first>
        <pg:prev>
            <a href="${pageUrl}">上一页</a>
        </pg:prev>
        <pg:pages>
            <c:choose>
                <c:when test="${curPage eq pageNumber}">
                    <font color="red">[${pageNumber}]</font>
                </c:when>
                <c:otherwise>
                    <a href="${pageUrl}">${pageNumber}</a>
                </c:otherwise>
            </c:choose>
        </pg:pages>
        <pg:next>
            <a href="${pageUrl}">上一页</a>
        </pg:next>

        <pg:last>
            <c:choose>
                <c:when test="${curPage eq pageNumber}">
                    <font color="red">尾页</font>
                </c:when>
                <c:otherwise>
                    <a href="${pageUrl}">尾页</a>
                </c:otherwise>
            </c:choose>
        </pg:last>
    </pg:pager>--%>

 <table>
    <thead>
    <tr>
        <th>商家姓名</th>
        <th>订单号</th>
        <th>买家id</th>
        <th>余额</th>
        <th>交易时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfos.list}" var="page">
        <tr>
            <td>${page.id}</td>
            <td>${page.keepername}</td>
            <td>${page.exchange_id}</td>
            <td>${page.buyerid}</td>
            <td>${page.keepercount}</td>
            <td><fmt:formatDate value="${page.exchange_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br><br>

<div class="col-md-6">
    当前是第 ${pageInfos.pageNum} 页，总共是 ${pageInfos.pages} 页, 总共有 ${pageInfos.total} 条信息

</div>

<div class="col-md-6">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li><a href="${pageContext.request.contextPath}/shopkeeper/goto_shopkeeperJSP?pn=1">首页</a></li>

            <c:if test="${ pageInfos.hasPreviousPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/shopkeeper/goto_shopkeeperJSP?pn=${pageInfos.pageNum-1}" aria-label="Previous">上一页</a>
                </li>
            </c:if>

            <c:forEach items="${pageInfos.navigatepageNums}" var="page_Num">
                <c:if test="${page_Num == pageInfos.pageNum }">
                    <li class="active"><a href="#">${page_Num }</a></li>

                </c:if>
                <c:if test="${page_Num != pageInfos.pageNum }">
                    <li><a href="${pageContext.request.contextPath}/shopkeeper/goto_shopkeeperJSP/?pn=${page_Num }">${page_Num }</a></li>

                </c:if>

            </c:forEach>
            <c:if test="${pageInfos.hasNextPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/shopkeeper/goto_shopkeeperJSP?pn=${pageInfos.pageNum +1}" aria-label="Next">
                       下一页
                    </a>
                </li>

            </c:if>
            &nbsp;&nbsp;
            <li><a href="${pageContext.request.contextPath}/shopkeeper/goto_shopkeeperJSP?pn=${pageInfos.pages}">末页</a></li>
        </ul>
    </nav>
</div>




<script type="text/javascript">
    window.load(
      $.ajax({
            url:"${pageContext.request.contextPath}/shopkeeper/goto_shopkeeperJSP",
            data:{"fn": 1},
            type:"post",
            success:function(result) {
                console.log(result);
            }


        })


    )

</script>

</body>
</html>
