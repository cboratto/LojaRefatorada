/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller.app;

import bean.session.CarrinhoBeanRemote;
import bean.session.ProdutoBeanRemote;
import entity.bean.CarrinhoItem;
import entity.bean.Produto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import loja.controller.frontcontroller.AbstractApplicationController;
import util.JNDIUtil;

/**
 *
 * @author caioboratto
 */
public class LojaController extends AbstractApplicationController {

    @Override
    public void execute() {
        String origem;

        //seleciona o parametro caso estiver setado
        try {
            origem = this.getRequest().getParameter("orig");
            if (origem == null) {
                origem = "inicio";
            }
        } catch (Exception e) {
            origem = "inicio";
        }

        if (origem.equals("adicionaItem")) {
            //produto selecionado na tela
            String idProduto = this.getRequest().getParameter("idProduto");
            try {
                //busca bean
                Context context = JNDIUtil.getCORBAInitialContext();
                ProdutoBeanRemote produtoBean = (ProdutoBeanRemote) context.lookup("ProdutoBean");

                Integer id = Integer.parseInt(idProduto);
                Produto produtoSelecionadoNatela = produtoBean.getProdutoSelecionado(id);

                //produto selecionado com sucesso. 
                //Agora temos de adicionar ao carrinho da sessao 
                CarrinhoBeanRemote carrinhoBean = (CarrinhoBeanRemote) context.lookup("CarrinhoBean");
                carrinhoBean.addItemCarrinho(produtoSelecionadoNatela);
                //Produto adicionado redireciona para loja
                this.setReturnPage("/FrontControllerServlet?control=Loja");
            } catch (Exception ex) {
                Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {

                Context context = JNDIUtil.getCORBAInitialContext();
                ProdutoBeanRemote produtoBean = (ProdutoBeanRemote) context.lookup("ProdutoBean");

                //teste para subida de produtos                
                List<Produto> listaProdutos = produtoBean.getObjectList();
                this.getRequest().setAttribute("produtos", listaProdutos);
                this.setReturnPage("/loja/inicio.jsp");

            } catch (Exception ex) {
                Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
