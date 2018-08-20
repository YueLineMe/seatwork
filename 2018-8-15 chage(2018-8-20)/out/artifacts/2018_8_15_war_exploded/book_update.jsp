<%@ page import="entity.Book" %>
<%@ page import="dao.BookDao" %>

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
    <form action="/BookContro?action=update" class="form-horizontal" method="post">
        <div><input type="text" name="name" placeholder="name" value="<c:out value="${book.name}"></c:out>"></div>
        <div><input type="number" step="0.01" name="price" placeholder="price"
                    value="<c:out value="${book.price}"></c:out>"></div>
        <div><input type="text" name="author" placeholder="author" value="<c:out value="${book.author}"></c:out>"></div>
        <div><input type="text" name="press" placeholder="press" value="<c:out value="${book.press}"></c:out>"></div>
        <div><input type="hidden" name="Id" value="<c:out value="${book.id}"></c:out>"></div>
        <div><input type="submit" value="提交更新" class=""></div>
    </form>
    <button class="btn" onclick="javascript:history.back(-1);">返回</button>
    <span data-toggle="modal" data-target="#myModal" id="dialog"></span>
    <button class="btn btn-info" type="button" id="y-modalBtnAdd" style="display: none;" > <label >添加</label></button>
    <!-- 模态弹出窗内容 -->
    <div class="modal" id="y-myModalAdd" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"  aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">×</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p id="msg">通过js绑定button和弹出层触发</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    <!--js代码-->
    <script src="js/jquery-1.11.3.js"></script>

    <c:if test="${bool}">
        <script type="text/javascript">
            $(function(){
                // dom加载完毕
                var $m_btn = $('#y-modalBtnAdd'); //y-modalBtnAdd是button的id
                var $modal = $('#y-myModalAdd'); //y-myModalAdd是弹出的遮罩层的id，通过这两个id进行绑定
                $m_btn.on('click', function(){
                    $modal.modal({backdrop: 'static'});
                });
                $("#msg").html("${msg}")
                $m_btn.click();
            });
        </script>
    </c:if>

</div>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>
