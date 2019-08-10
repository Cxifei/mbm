<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加</title>
</head>
<body>
    <form action="/item/save" method="post">
        <input type="text" name="title" placeholder="标题">
        <input type="number" name="price" placeholder="价格">
        <input type="number" name="num" placeholder="库存">
        <select name="categoryId">
            <option value="1">母婴</option>
        </select>
        <input type="submit" value="提交">
    </form>
</body>
</html>
