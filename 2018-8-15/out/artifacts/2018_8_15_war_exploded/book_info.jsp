<%@ page import="entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Book book= (Book) request.getAttribute("book_info");
%>
<h2><%=book.getName()%></h2>
<ul>
    <li>价  格：<%=book.getPrice()%></li>
    <li>作  者：<%=book.getAuthor()%></li>
    <li>出版社：<%=book.getPress()%></li>
</ul>
</body>
</html>
