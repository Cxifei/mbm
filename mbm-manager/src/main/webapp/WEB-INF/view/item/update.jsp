<%--
  Created by IntelliJ IDEA.
  User: always_on_the_way
  Date: 2019/7/16
  Time: 下午7:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品信息更新</title>
</head>
<body>
<form action="/item/update/" method="post">
    <label>更新商品信息</label>
    <input type="hidden" name="id" value="${id}">
    <input type="text" name="title" placeholder="标题">
    <input type="number" name="price" placeholder="价格">
    <input type="number" name="num" placeholder="库存">
    <select name="categoryId">
        <option value="1">母婴</option>
    </select>
    <input type="submit" value="更新">
</form>
</body>
</html>
