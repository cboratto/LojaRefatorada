<%-- 
    Document   : efetuado
    Created on : May 11, 2015, 9:28:06 PM
    Author     : caioboratto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja - Pedido</title>
    </head>
    <body>
        <%
            Integer idPedido = (Integer) request.getAttribute("idpedido");
        %>
        <h1>Pedido efetuado com sucesso</h1>
        <h3>Código do pedido <%=idPedido%></h3>
    </body>
</html>
