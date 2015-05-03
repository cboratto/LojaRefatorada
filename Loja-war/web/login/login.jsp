<%-- 
    Document   : login
    Created on : Apr 25, 2015, 9:38:53 AM
    Author     : caioboratto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="/Loja-war/FrontControllerServlet?control=Login">            
            <p>Usuario:  <input type="text" name="usuario"></p>            
            <p>Senha:  <input type="password" name="senha"></p>            
            <p><input type="submit"></p>
        </form
        <li><a href="/Loja-war/cadastro/cadastro.jsp">Cadastrar-se</a></li>
    </body>
</html>
