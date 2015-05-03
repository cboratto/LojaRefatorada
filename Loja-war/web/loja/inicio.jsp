<%-- 
    Document   : inicio
    Created on : May 3, 2015, 4:41:18 PM
    Author     : caioboratto
--%>

<%@page import="java.util.List"%>
<%@page import="entity.bean.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja</title>
    </head>
    <body>
        <h1>Bem vindo</h1>
        <form method="POST" action="/MackTur/FrontControllerServlet?control=SaveSelectedFlightServlet">
            <table border="1">
                <tr><th>Foto</th><th>Nome</th><th>Descrição</th><th>Categoria</th><th>Valor</th>
                </tr>
                </tr>
                <%
                    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
                    for (Produto p : produtos) {

                %>

                <tr>
                    <td><img src="<%=p.getDesUrlImg()%>"  width="250" height="200" /></td>                                     
                    <td><%=p.getNomProduto()%></td>
                    <td><%=p.getDesProduto()%></td>
                    <td><%=p.getIdProduto()%></td>
                    <td><%=p.getValProduto() %></td>                    
                </tr>
                <%
                    }
                %>
            </table>

            <p><input type="submit" name="Enviar"></p>
        </form>

    </body>
</html> 
