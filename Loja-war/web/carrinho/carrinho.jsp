<%-- 
    Document   : carrinho
    Created on : May 6, 2015, 6:59:16 PM
    Author     : caioboratto
--%>

<%@page import="entity.bean.Cliente"%>
<%@page import="entity.bean.CarrinhoItem"%>
<%@page import="java.util.List"%>
<%@page import="entity.bean.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja - Carrinho</title>
    </head>
    <body>
        <h1>Carrinho</h1>
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
        <form method="POST" action="/Loja-war/FrontControllerServlet?control=Carrinho&action=efetuarCompra">
            <table border="1">
                <% try { %>
                <tr><th>Foto</th><th>Nome</th><th>Categoria</th><th>Quantidade</th><th>Valor</th><th>Valor total</th></tr>

                <%
                    Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
                    List<CarrinhoItem> listaCarrinhoItem = carrinho.getCarrinhoItemList();
                    for (CarrinhoItem c : listaCarrinhoItem) {

                %>

                <tr>
                    <td><img src="<%=c.getIdProduto().getDesUrlImg()%>"  width="240" height="190" /></td>                                     
                    <td><%=c.getIdProduto().getNomProduto()%></td>
                    <td><%=c.getIdProduto().getIdCategoria().getNomCategoria()%></td>
                    <td><%=c.getQtdItem()%></td>
                    <td><%=c.getIdProduto().getValProduto()%></td>          
                    <td><%=c.getIdProduto().getValProduto() * c.getQtdItem()%></td>          
                </tr>
                <%
                    }
                } catch (Exception e) {
                %>
                <h3>Nao existe objetos no carrinho</h3>
                <%
                    }
                %>

            </table>
            <h4>Comprar</h4>
            <p><input type="submit" name="Enviar"></p>
        </form>
    </body>
</html>
