<%-- 
    Document   : inicio
    Created on : May 3, 2015, 4:41:18 PM
    Author     : caioboratto
--%>

<%@page import="entity.bean.Cliente"%>
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
        <%
            String usuario;
            Cliente cliente;
            try {
                cliente = (Cliente) request.getSession().getAttribute("usuario");
                usuario = cliente.getLogin().getNamLogin();
            } catch (Exception e) {
                usuario = "Nao logado";
            }
        %>
        <h3>Usuário: <%=usuario%></h3>
        <form method="POST" action="/Loja-war/FrontControllerServlet?control=Loja&orig=adicionaItem">
            <table border="1">
                <tr><th>Foto</th><th>Nome</th><th>Descrição</th><th>Categoria</th><th>Valor</th>
                </tr>
                </tr>
                <%
                    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
                    for (Produto p : produtos) {

                %>

                <tr>
                    <td><img src="<%=p.getDesUrlImg()%>"  width="240" height="190" /></td>                                     
                    <td><%=p.getNomProduto()%></td>
                    <td><%=p.getDesProduto()%></td>
                    <td><%=p.getIdCategoria().getNomCategoria()%></td>
                    <td><%=p.getValProduto()%></td>          
                    <td><input type="radio" name="idProduto" value=<%=p.getIdProduto() %>></td>
                </tr>
                <%
                    }
                %>
            </table>

            <p><input type="submit" name="Enviar"></p>
        </form>

    </body>
</html> 
