<%--
  Created by IntelliJ IDEA.
  User: always_on_the_way
  Date: 2019/7/16
  Time: 下午3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>商品名称</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>
                <a href="/item/${item.id}">删除</a>
            </td>
            <td>
                <a href="/item/upd/${item.id}">更新</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
