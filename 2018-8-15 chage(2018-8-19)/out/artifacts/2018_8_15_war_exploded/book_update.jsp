<%@ page import="entity.Book" %>
<%@ page import="dao.BookDao" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.css">
</head>
<body>
<%
    BookDao dao = new BookDao();
    String temp = request.getParameter("Id");
    int Id = 0;
    if (temp != null) {
        Id = Integer.parseInt(temp);
    }
    Book book = dao.getBookById(Id);
%>
<div style="margin: auto;width: 600px;margin-top: 50px;">
    <form action="/BookContro?action=update" class="form-horizontal" method="post">
        <div><input type="text" name="name" placeholder="name" value="<%= book.getName()%>"></div>
        <div><input type="number" step="0.01" name="price" placeholder="price" value="<%= book.getPrice()%>"></div>
        <div><input type="text" name="author" placeholder="author" value="<%= book.getAuthor()%>"></div>
        <div><input type="text" name="press" placeholder="press" value="<%= book.getPress()%>"></div>
        <div><input type="hidden" name="Id" value="<%= book.getId()%>"></div>
        <div><input type="submit" value="提交更新" class=""></div>
</form>
    <button class="btn" onclick="javascript:history.back(-1);">返回</button>
</div>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>
