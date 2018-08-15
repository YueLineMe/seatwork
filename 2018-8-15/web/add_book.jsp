<%@ page import="entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="BookContro?action=add" method="post">
    <div><input type="text" name="Id" placeholder="ID"></div>
    <div><input type="text" name="name" placeholder="书籍名称"></div>
    <div><input type="text" name="price" placeholder="价格"></div>
    <div><input type="text" name="author" placeholder="作者"></div>
    <div><input type="text" name="press" placeholder="出版社"></div>
    <div><input type="submit"></div>
</form>
</body>
</html>
