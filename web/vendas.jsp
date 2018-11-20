<%--
  Created by IntelliJ IDEA.
  User: gustavo.agnes
  Date: 19/11/2018
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="./css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2 align="center">Gerência</h2>
    <form action="${pageContext.request.contextPath}/vendasServlet" method="post">
        <button align="center" class="btn btn-primary" type="submit">Consultar Vendas</button>
    </form>
</div>
</body>
</html>
