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
        <h2 id="gerencia">Gerência</h2>
    <form action="${pageContext.request.contextPath}/vendasServlet" method="post">
            <div class="col-md-4 center-block">
                <button class="btn btn-primary" type="submit" name="consulta" value="consulta">Consultar Vendas</button>
          </div>
        </form>
</body>
</html>
