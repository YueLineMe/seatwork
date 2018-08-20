<%@ page import="entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.css">
</head>
<body>
<div style="margin: auto;width: 600px;margin-top: 50px;">
    <h2><c:out value="${book_info.name}"></c:out>
    </h2>
    <ul class="inline">
        <li>价&nbsp&nbsp格：<c:out value="${book_info.price}"></c:out>
        </li>
        <li>作&nbsp&nbsp者：<c:out value="${book_info.author}"></c:out>
        </li>
        <li>出版社：<c:out value="${book_info.press}"></c:out>
        </li>
    </ul>
    <button class="btn" onclick="javascript:history.back(-1);">返回</button>
</div>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>
