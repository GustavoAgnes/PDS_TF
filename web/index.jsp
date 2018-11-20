<%@page language="java" contentType="text/html; charset=ISO-8859-1" %>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
<html>
<head>
    <link href="./css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!------ Include the above in your HEAD tag ---------->
</head>
<body id="LoginForm">
<div class="container">
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>Login Gerência</h2>
                <p>Coloque seu usuário e senha</p>
            </div>
            <form id="loginFormId" name="loginForm" method="post" action="<%=request.getContextPath()%>/loginServlet">
                <div class="form-group">
                    <input type="text" class="form-control" id="username" placeholder="Usuario" name="username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="password" placeholder="Senha" name="password">
                </div>
                <div class="forgot">
                </div>
                <button type="submit" class="btn btn-primary" value="Login">Login</button>
            </form>
        </div>
    </div>
</div>
</div>


</body>
</html>