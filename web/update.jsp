<%--
  Created by IntelliJ IDEA.
  User: offcn
  Date: 2022/4/29
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="StudentServlet?method=update">
    <table border="1px" cellspacing="0" width="300px" align="center">
        <caption>学生信息修改</caption>
        <tr>
            <td align="center">
                <input type="hidden" name="id" value="${requestScope.student.id}" />
            </td>
        </tr>
        <tr>
            <td align="right">姓名</td>
            <td>
                <input type="text" name="name" id="name" value="${requestScope.student.name}">
            </td>
        </tr>
        <tr>
            <td align="right">年龄</td>
            <td>
                <input type="text" name="age" id="age" value="${requestScope.student.age}">
            </td>
        </tr>
        <tr>
            <td align="right">成绩</td>
            <td>
                <input type="text" name="score" id="score" value="${requestScope.student.score}">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="更新">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
