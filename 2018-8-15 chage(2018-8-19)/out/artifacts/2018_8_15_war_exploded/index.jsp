<%@ page import="dao.BookDao" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.css">
</head>
<body>
<div style="margin: auto;width: 600px;margin-top: 50px;">
    <form class="form-search form-horizontal" action="BookContro?action=selectName" style="float: right;" method="post">
        <input type="text"  placeholder="查询条件(名字)" name="name">
        <input type="submit" class="submit" value="搜索">
    </form>
    <table cellpadding="0" cellspacing="0" border="1" style="text-align:center;" class="table table-striped">
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
            List<Book> list = null;
            list = dao.getAll();
            if (request.getAttribute("books") != null) {
                list = (List<Book>) request.getAttribute("books");
            }
            for (Book book : list) {
        %>
        <tr>
            <td><%=book.getId()%>
            </td>
            <td><a href="BookContro?action=selectId&Id=<%=book.getId()%>"><%=book.getName()%>
            </a></td>
            <td><%=book.getPrice()%>
            </td>
            <td><%=book.getAuthor()%>
            </td>
            <td><%=book.getPress()%>
            </td>
            <td><a href="BookContro?action=del&Id=<%=book.getId()%>">删除</a> <a
                    href="book_update.jsp?Id=<%=book.getId()%>">更改</a></td>
        </tr>
        <%
            }
        %>

    </table>
    <a href="BookContro?action=prepare_add" style="margin-top: 25px;">添加</a>
</div>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>
