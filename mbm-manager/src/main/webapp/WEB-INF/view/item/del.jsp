<%--
  Created by IntelliJ IDEA.
  User: always_on_the_way
  Date: 2019/7/15
  Time: 下午7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除商品</title>
</head>
<body>

    <form action="/item/delete" method="post">
        <input type="text" name="categoryId" placeholder="商品编码">
        <input type="submit" value="提交">
    </form>
</body>
</html>
