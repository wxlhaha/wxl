<%--
  Created by IntelliJ IDEA.
  User: offcn
  Date: 2022/5/5
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #div{
            cursor: pointer;
        font-size: 12px;
        }
    </style>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            //键盘抬起事件
        $("#productname").keyup(function () {
        //获取数据框的数据
            var productname = $("#productname").val();
            //异步请求查询数据
            $.getJSON("ProductServlet",{"productname":productname},function (data) {
            if (data != null){
                var str = "";
                for (var i = 0; i < data.length; i++) {
                    str += "<div>" + data[i].productname + "</div>";
                }
                $("#div").html(str)
            }
            })
        })
        });
        //页面补充
       function changeContent(e) {
           //找到事件源
           var e = e || event;     //浏览器兼容
           var target = e.target || e.srcElement; //不同浏览器获取事件源
           //点击的事件源添加到输入框中  值
           $("#productname").val($(target).html());
           //展示结果的div 没有内容
           $("#div").html("");
       }
    </script>
</head>
<body>
<%--填写数据的文本框--%>
<input type="text" name="productname" id="productname" style="width: 300px  ">
<div id="div" style="width: 300px" onclick="changeContent(event)" ></div>
</body>
</html>
