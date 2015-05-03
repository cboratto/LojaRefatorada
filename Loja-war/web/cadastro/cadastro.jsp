<%-- 
    Document   : cadastro
    Created on : Apr 25, 2015, 10:04:52 AM
    Author     : caioboratto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja - Cadastro</title>
    </head>
    <body>
        <h1>Formulario de Cadastro</h1>
        <form method="POST" action="/Loja-war/FrontControllerServlet?control=Cadastrar">            
            <h3>Usuario</h3>
            <p>Usuario:  <input type="text" name="user"></p>            
            <p>Senha:   <input type="password" name="senha"></p>            
            <h3>Informações Pessoais</h3>
            <p>Nome:  <input type="text" name="nome"></p>            
            <p>CPF/CNPJ:  <input type="text" name="documento"></p>            
            <p>Email:  <input type="text" name="email"></p>                       
            <p>Endereço:  <input type="text" name="endereco"></p>                       
            <p>Complemento:  <input type="text" name="complemento"></p>
            <p><input type="submit"></p>
        </form
    </body>
</html>
