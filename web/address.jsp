<%--
  Created by IntelliJ IDEA.
  User: offcn
  Date: 2022/5/5
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        //页面加载完成
        $(function (){
            //1查询所有国家  将查询到的结果写到countrysel中  <option value = "1">中国</option>
            $.get("CountryServlet",function (data) {
                //data不是jq对象 是字符串  eval()
                var obj = eval("(" + data + ")");
                var str = "";
                for (var i = 0; i < obj.length ; i++) {
                    str = str + "<option value ='" +  obj[i].id + "'>" + obj[i].name + "</option>"
                }
                $("#CountrySel").html( $("#CountrySel").html() + str);
            });
//选取国家完毕  异步加载城市  值改变事件
            $("#CountrySel").change(function () {
        //获得国家id   选择框中的值
                var countryId = $("#CountrySel").val();
                $.getJSON("CityServlet",{"countryId":countryId},function (data) {
                //data  不要使用eval函数处理
                    if (data.length > 0){
                        var str = "";
                        for (var i = 0; i < data.length ; i++) {
                            str += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";

                        }
                        $("#CitySel").html(str);
                    }else {
                        $("#CitySel").html("<option value='0'>-请选择-</option>")
                    }
                })
            })
        })
    </script>
</head>
<body>
<select name="CountrySel" id="CountrySel">
    <option value="0">-请选择-</option>
</select>
<select name="CitySel" id="CitySel">
    <option value="0">-请选择-</option>
</select>
</body>
</html>
