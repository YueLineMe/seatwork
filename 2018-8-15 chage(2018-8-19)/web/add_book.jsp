<%@ page import="entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
<div style="margin: auto;width: 600px;margin-top: 50px;">
    <form action="BookContro?action=add" class="form-horizontal" method="post">
        <div><input type="text" name="Id" placeholder="ID"></div>
        <div><input type="text" name="name" placeholder="书籍名称"></div>
        <div><input type="text" name="price" placeholder="价格"></div>
        <div><input type="text" name="author" placeholder="作者"></div>
        <div><input type="text" name="press" placeholder="出版社"></div>
        <div><input type="submit" class="submit"></div>
</form>
    <button class="btn" onclick="javascript:history.back(-1);">返回</button>
</div>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>
