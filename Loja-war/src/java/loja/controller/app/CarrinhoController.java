/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.CarrinhoBeanRemote;
import bean.session.PedidoBeanRemote;
import entity.bean.Carrinho;
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
                CarrinhoBeanRemote carrinhoBean = (CarrinhoBeanRemote) context.lookup("CarrinhoBean");

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

                pedidoBean.save(novoPedido);

                this.setReturnPage("/pedido/pedido.jsp");
            } catch (Exception ex) {
                Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
