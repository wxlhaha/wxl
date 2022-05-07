<%--
  Created by IntelliJ IDEA.
  User: offcn
  Date: 2022/4/29
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有学生</title>
</head>
<body>
<table border="1px" width="60%" align="center" cellspacing="0">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>成绩</td>
        <td>操作</td>
    </tr>
  <c:forEach items="${requestScope.slist}" var="s">
      <tr>
          <td>${s.id}</td>
          <td>${s.name}</td>
          <td>${s.age}</td>
          <td>${s.score}</td>
          <td>
              <a href="StudentServlet?method=find&id=${s.id}">修改</a>
              <a href="javascript:delStudent(${s.id})">删除</a>
          </td>
      </tr>
  </c:forEach>
    <tr>
        <td colspan="5">
<%--        首页--%>
    <a href="StudentServlet?method=findall&currPage=1">首页</a>
<%--            上一页--%>
            <c:if test="${requestScope.page.currentPage != 1}">
                <a href="StudentServlet?method=findall&currPage=${requestScope.page.currentPage-1}">上一页</a>
            </c:if>
<%--            页码--%>
            <c:forEach begin="1" end="${requestScope.page.totalPage}" var="n">
                 <c:choose>
                     <c:when test="${requestScope.page.currentPage==n}">
                         <a href="StudentServlet?method=findall&currPage=${n}" style="color: red">${n}</a>
                     </c:when>
                     <c:otherwise>
                         <a href="StudentServlet?method=findall&currPage=${n}">${n}</a>
                     </c:otherwise>
                 </c:choose>
            </c:forEach>
<%--            //下一页--%>
            <c:if test="${requestScope.page.currentPage != requestScope.page.totalPage}">
                <a href="StudentServlet?method=findall&currPage=${requestScope.page.currentPage+1}">下一页</a>
            </c:if>
<%--            尾页--%>
    <a href="StudentServlet?method=findall&currPage=${requestScope.page.totalPage}">尾页</a>
            共分${requestScope.page.totalPage}页
        </td>
    </tr>
</table>
</body>
<script>
    function delStudent(id) {
        var flag = confirm("确定删除吗?");
        if (flag){
            location = "StudentServlet?method=del&id=" + id;
        }
    }
</script>
</html>
