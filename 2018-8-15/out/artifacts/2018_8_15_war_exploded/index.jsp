<%@ page import="dao.BookDao" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1" style="text-align:center;">
    <tr>
        <th>ID</th>
        <th>书籍名称</th>
        <th>价格</th>
        <th>作者</th>
        <th>出版社</th>
        <th>操作</th>
    </tr>
    <%
        BookDao dao = new BookDao();
        List<Book> list = dao.getAll();
        for (Book book: list) {
    %>
    <tr>
        <td><%=book.getId()%></td>
        <td><a href="BookContro?action=selectId&Id=<%=book.getId()%>"><%=book.getName()%></a></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getAuthor()%></td>
        <td><%=book.getPress()%></td>
        <td>暂无</td>
    </tr>
    <%
        }
    %>
    <a href="BookContro?action=prepare_add" style="margin-top: 25px;">添加</a>
</table>
</body>
</html>
