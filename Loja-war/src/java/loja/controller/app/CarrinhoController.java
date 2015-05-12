/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.CarrinhoBeanRemote;
import bean.session.PedidoBeanRemote;
import entity.bean.Carrinho;
import entity.bean.CarrinhoItem;
import entity.bean.Cliente;
import entity.bean.Pedido;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import loja.controller.frontcontroller.AbstractApplicationController;
import util.JNDIUtil;

/**
 *
 * @author caioboratto
 */
public class CarrinhoController extends AbstractApplicationController {

    @Override
    public void execute() {
        String action;
        CarrinhoBeanRemote carrinhoBean;
        //seleciona o parametro caso estiver setado
        try {
            action = this.getRequest().getParameter("action");
            if (action == null) {
                action = "inicio";
            }
        } catch (Exception e) {
            action = "inicio";
        }
        if (!action.equals("efetuarCompra")) {
            try {
                //busca bean
                Context context = JNDIUtil.getCORBAInitialContext();
                carrinhoBean = (CarrinhoBeanRemote) context.lookup("CarrinhoBean");

                //Produto adicionado redireciona para loja
                this.setReturnPage("/carrinho/carrinho.jsp");
            } catch (Exception ex) {
                Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // COMPRAR
        } else {
            try {
                //busca bean
                Context context = JNDIUtil.getCORBAInitialContext();
                PedidoBeanRemote pedidoBean = (PedidoBeanRemote) context.lookup("PedidoBean");

                Cliente cliente = (Cliente) this.getRequest().getSession().getAttribute("usuario");
                Carrinho carrinho = (Carrinho) this.getRequest().getSession().getAttribute("carrinho");

                carrinho.setIdCliente(cliente.getLogin());
                cliente.getLogin().addCarrinho(carrinho);

                Pedido novoPedido = new Pedido();
                novoPedido.setIdCarrinho(carrinho);

                Integer idPedido = pedidoBean.saveReturnPedido(novoPedido);
                this.getRequest().setAttribute("idpedido", idPedido);
                this.getRequest().setAttribute("desemail", cliente.getDesEmail());
                this.setReturnPage("/pedido/efetuado.jsp");
                
                String descricao;
                descricao = "Nome Produto\tQuantidade\tValor unitário\tValor total\n";
                for (CarrinhoItem c : carrinho.getCarrinhoItemList()) {
                    descricao = descricao + c.getIdProduto().getNomProduto()+"\t"+c.getQtdItem()+"\t"+c.getIdProduto().getValProduto()+"\t"+c.getIdProduto().getValProduto()*c.getQtdItem()+"\n" ;                    
                }
                pedidoBean.enviarEmailParaComprador(idPedido, cliente.getNomCliente(), cliente.getDesEmail(),descricao);
                
                this.getRequest().getSession().setAttribute("carrinho", null);
            } catch (Exception ex) {
                Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
