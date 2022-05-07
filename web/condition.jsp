<%--
  Created by IntelliJ IDEA.
  User: offcn
  Date: 2022/4/29
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="StudentServlet?method=selectstudentbycondition" method="post">
    <table border="1px" width="45%" align="center" cellspacing="0">
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" id="name" placeholder="请输入姓名">
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" id="age" placeholder="请输入年龄">
            </td>
        </tr>
        <tr>
            <td>成绩</td>
            <td>
                <input type="text" name="score" id="score" placeholder="请输入成绩">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="查询">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
