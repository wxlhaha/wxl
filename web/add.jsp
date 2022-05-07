<%--
  Created by IntelliJ IDEA.
  User: offcn
  Date: 2022/4/29
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="StudentServlet?method=addstudent" method="post" >
    <table border="1px" cellspacing="0" width="300px" align="center">
        <caption>学生添加</caption>
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
                <input type="submit" value="添加">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
