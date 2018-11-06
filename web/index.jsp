<%--
  Created by IntelliJ IDEA.
  User: gustavo.agnes
  Date: 25/10/2018
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <title>Gerencia Login</title>
  <style type="text/css">
    .paddingBtm {
      padding-bottom: 12px;
    }
  </style>
</head>
<body>
<center>
  <h2>Gerencia Login</h2>
  <form id="loginFormId" name="loginForm" method="post" action="loginServlet">
    <div id="usernameDiv" class="paddingBtm">
      <span id="user">Usuario: </span><input type="text" name="username" />
    </div>
    <div id="passwordDiv" class="paddingBtm">
      <span id="pass">Senha: </span><input type="password" name="password" />
    </div>
    <div id="loginBtn">
      <input id="btn" type="submit" value="Login" />
    </div>
  </form>
</center>
</body>
</html>